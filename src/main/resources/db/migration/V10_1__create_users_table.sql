<<<<<<< HEAD:src/main/resources/db/migration/V2_1__create_users_table.SQL
CREATE TABLE `users`
(
    `id`         int(11)                                                                              NOT NULL AUTO_INCREMENT,
    `login`      varchar(60) COLLATE utf8mb4_unicode_ci                                               NOT NULL,
    `password`   varchar(255) COLLATE utf8mb4_unicode_ci                                              NOT NULL,
    `firstname`  varchar(60) COLLATE utf8mb4_unicode_ci                                               NOT NULL,
    `lastname`   varchar(60) COLLATE utf8mb4_unicode_ci                                               NOT NULL,
    `email`      varchar(255) COLLATE utf8mb4_unicode_ci                                              NOT NULL,
    `langue`     varchar(2) COLLATE utf8mb4_unicode_ci                                                NOT NULL,
    `role`       enum ('ADMIN','MEMBER','AFFILIATE','PRESS','PRODUCER','') COLLATE utf8mb4_unicode_ci NOT NULL,
    `created_at` datetime                                                                             NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
=======
CREATE TABLE `users` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `login` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
                         `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                         `firstname` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
                         `lastname` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
                         `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                         `langue` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,
                         `created_at` datetime NOT NULL,
                         PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a:src/main/resources/db/migration/V10_1__create_users_table.sql
