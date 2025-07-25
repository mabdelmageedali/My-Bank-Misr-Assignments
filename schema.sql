create database ecommerce_db;
use ecommerce_db;


create table users (
    user_id int auto_increment primary key,
    username varchar(50) not null,
    email varchar(100) not null unique,
    password_hash varchar(255) not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    is_admin boolean default false,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,
    index idx_user_email (email)
);


create table categories (
    category_id int auto_increment primary key,
    name varchar(50) not null,
    description text,
    created_at timestamp default current_timestamp
);


create table products (
    product_id int auto_increment primary key,
    name varchar(100) not null,
    description text,
    price decimal(10, 2) not null,
    stock_quantity int not null default 0,
    category_id int not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,
    foreign key (category_id) references categories(category_id) on delete restrict on update cascade,
    index idx_product_name (name),
    index idx_product_category (category_id)
);


create table promotions (
    promotion_id int auto_increment primary key,
    code varchar(20) not null unique,
    description text,
    discount_percent decimal(5, 2) not null,
    start_date datetime not null,
    end_date datetime not null,
    created_at timestamp default current_timestamp,
    index idx_promotion_code (code)
);


create table orders (
    order_id int auto_increment primary key,
    user_id int not null,
    order_date timestamp default current_timestamp,
    total_amount decimal(10, 2) not null,
    status enum('pending', 'processing', 'shipped', 'delivered', 'cancelled') default 'pending',
    promotion_id int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,
    foreign key (user_id) references users(user_id) on delete restrict on update cascade,
    foreign key (promotion_id) references promotions(promotion_id) on delete set null on update cascade,
    index idx_order_user (user_id),
    index idx_order_created_at (created_at)
);


create table order_items (
    order_id int not null,
    product_id int not null,
    quantity int not null,
    unit_price decimal(10, 2) not null,
    primary key (order_id, product_id),
    foreign key (order_id) references orders(order_id) on delete cascade on update cascade,
    foreign key (product_id) references products(product_id) on delete restrict on update cascade
);


create table saved_carts (
    cart_id int auto_increment primary key,
    user_id int not null,
    saved_at timestamp default current_timestamp,
    cart_data json not null,
    foreign key (user_id) references users(user_id) on delete cascade on update cascade,
    index idx_saved_cart_user (user_id)
);


delimiter //
create procedure sp_apply_promo(in promo_code varchar(20), in u_id int)
begin
    declare promo_id int;
    declare discount decimal(5, 2);
    declare promo_valid boolean default false;
    
    -- check if promotion exists and is valid
    select promotion_id, discount_percent into promo_id, discount
    from promotions
    where code = promo_code 
    and start_date <= now() 
    and end_date >= now()
    limit 1;
    
    if promo_id is not null then
        set promo_valid = true;
    end if;
    
    -- return result
    if promo_valid then
        select concat('promotion applied: ', discount, '% discount') as message;
    else
        select 'invalid or expired promotion code' as message;
    end if;
end //
delimiter ;


create view v_sales_summary as
select 
    date(o.created_at) as sale_date,
    count(o.order_id) as total_orders,
    sum(o.total_amount) as total_revenue,
    sum(oi.quantity) as total_items_sold
from orders o
join order_items oi on o.order_id = oi.order_id
group by date(o.created_at);

delimiter //
create trigger tg_update_stock_after_order
after insert on order_items
for each row
begin
    update products
    set stock_quantity = stock_quantity - new.quantity
    where product_id = new.product_id;
end //
delimiter ;