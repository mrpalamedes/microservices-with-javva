CREATE TABLE IF NOT EXISTS `cards`(
    `card_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `mobile_number` varchar(15) NOT NULL,
    `card_number` varchar(100) NOT NULL,
    `card_type` varchar(100) NOT NULL,
    `total_limit` int NOT NULL,
    `amount_used` int NOT NULL,
    `available_amount` int NOT NULL,
    `created_at` date NOT NULL,
    `created_by` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);