# E-Commerce Database Setup

## Connection Steps

   - Host: localhost
   - Port: 3306
   - Database: ecommerce_db
   - Username: [springstudent "this is my user name for SQL Workbench"]
   - Password: [Mahmoud@088564 this is my password for SQL Workbench"]

## Sample Queries

1-
select p.name, sum(oi.quantity) as total_sold
from products p
join order_items oi on p.product_id = oi.product_id
groub by p.product_id
order by total_sold desc
limit 1;

2-
select u.username, count(o.order_id) as order_count
from users u
left join orders o on u.user_id = o.user_id
group by u.user_id;

3-
select name, stock_quantity
from products
where stock_quantity < 20
order by stock_quantity asc;

4-
select c.name as category, sum(oi.quantity * oi.unit_price) as revenue
from categories c
join products p on c.category_id = p.category_id
join order_items oi on p.product_id = oi.product_id
group by c.category_id;

5-
select code, description, discount_percent
from promotions
where start_date <= now() and end_date >= now();
