# Personal-Library-Service

## Task 1: Endpoints

### Basic Endpoint

- **URL:** `http://localhost:8081/health`

- **Description:** Basic endpoint to test if the web server is running (implemented in `BasicController`).

- **Request Body:** None

- **Response:**

  ```
  OK
  ```

- **Example:**

  ```bash
  curl -X GET http://localhost:8081/health
  ```

- **Expected Response:**

  ```
  OK
  ```

---

### Greeting Service Endpoints

Test different greeting services for a given user.

---

#### 1. Morning Greeting

- **URL:** `http://localhost:8081/greet/morning/{user}`

- **Description:** Returns a morning greeting message from the `MorningGreetingService`.

- **Request Body:** None

- **Response:**

  ```
  Hello {user} From Morning Greeting Service!
  ```

- **Example:**

  ```bash
  curl -X GET http://localhost:8081/greet/morning/Seif
  ```

- **Expected Response:**

  ```
  Hello Seif From Morning Greeting Service!
  ```

---

#### 2. Evening Greeting

- **URL:** `http://localhost:8081/greet/evening/{user}`

- **Description:** Returns an evening greeting message from the `EveningGreetingService`.

- **Request Body:** None

- **Response:**

  ```
  Hello {user} From Evening Greeting Service!
  ```

- **Example:**

  ```bash
  curl -X GET http://localhost:8081/greet/evening/Ahmed
  ```

- **Expected Response:**

  ```
  Hello Ahmed From Evening Greeting Service!
  ```

---

#### 3. Default Greeting

- **URL:** `http://localhost:8081/greet/default/{user}`

- **Description:** Returns a default greeting message. The default service is `MorningGreetingService` (annotated with `@Primary`).

- **Request Body:** None

- **Response:**

  ```
  Hello {user} From Morning Greeting Service!
  ```

- **Example:**

  ```bash
  curl -X GET http://localhost:8081/greet/default/Mona
  ```

- **Expected Response:**

  ```
  Hello Mona From Morning Greeting Service!
  ```
