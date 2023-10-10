CREATE TABLE IF NOT EXISTS `Users`
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    username     VARCHAR(50)  NOT NULL,
    display_name VARCHAR(50),
    password     VARCHAR(255) NOT NULL,
    email        VARCHAR(255) NOT NULL,
    UNIQUE KEY unique_username (username),
    CHECK (CHAR_LENGTH(username) >= 4 AND CHAR_LENGTH(username) <= 50),
    CHECK (CHAR_LENGTH(display_name) >= 4 AND CHAR_LENGTH(display_name) <= 50),
    CHECK (CHAR_LENGTH(password) >= 6),
    CHECK (CHAR_LENGTH(email) >= 3 AND CHAR_LENGTH(email) <= 255)
);


CREATE TABLE IF NOT EXISTS `ProductCategory`
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    CHECK (CHAR_LENGTH(name) >= 2 AND CHAR_LENGTH(name) <= 50)
);

CREATE TABLE IF NOT EXISTS `Product`
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    name                VARCHAR(255)   NOT NULL,
    description         VARCHAR(1024)  NOT NULL,
    price               DECIMAL(10, 2) NOT NULL,
    product_category_id BIGINT,
    FOREIGN KEY (product_category_id) REFERENCES ProductCategory (id)
);

CREATE TABLE IF NOT EXISTS `Bank`
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    CHECK (CHAR_LENGTH(name) >= 2 AND CHAR_LENGTH(name) <= 100)
);

CREATE TABLE IF NOT EXISTS `AccountType`
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    CHECK (CHAR_LENGTH(name) >= 2 AND CHAR_LENGTH(name) <= 50)
);

CREATE TABLE IF NOT EXISTS `Account`
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    account_number  INT,
    account_agency  INT,
    account_type_id BIGINT,
    bank_id         BIGINT,
    users_id        BIGINT,
    FOREIGN KEY (account_type_id) REFERENCES AccountType (id),
    FOREIGN KEY (bank_id) REFERENCES Bank (id),
    FOREIGN KEY (users_id) REFERENCES Users (id)
);


CREATE TABLE IF NOT EXISTS `Expense`
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    description         VARCHAR(256),
    value               DECIMAL(10, 2)                                               NOT NULL,
    payment_method      ENUM ('CREDIT_CARD', 'DEBIT_CARD', 'MONEY', 'PIX', 'CHEQUE') NOT NULL,
    transaction_status  ENUM ('PENDING', 'PAYMENT_RECEIVED', 'FAILED')               NOT NULL,
    expense_type        ENUM ('SPENDING', 'WITHDRAWAL', 'TRANSFER')                  NOT NULL,
    account_id          BIGINT,
    account_transfer_id BIGINT,
    product_id          BIGINT,
    FOREIGN KEY (account_id) REFERENCES Account (id),
    FOREIGN KEY (account_transfer_id) REFERENCES Account (id),
    FOREIGN KEY (product_id) REFERENCES Product (id)
);

CREATE TABLE IF NOT EXISTS `PaymentStatusHistory`
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    pending_date       DATE   NOT NULL,
    paid_received_date DATE   NOT NULL,
    expense_id         BIGINT NOT NULL,
    FOREIGN KEY (expense_id) REFERENCES Expense (id)
);