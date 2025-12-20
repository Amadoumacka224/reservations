<<<<<<< HEAD
CREATE TABLE `reservations`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT,
    `user_id`      int(11) NOT NULL,
    `booking_date` DATETIME,
    `status`       VARCHAR(60),
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
=======
CREATE TABLE `reservations` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `user_id` int(11) NOT NULL,
                                `representation_id` int(11) NOT NULL,
                                `places` int(11) NOT NULL,
                                PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a

--
-- Index pour la table `reservations`
--
ALTER TABLE `reservations`
    ADD KEY `reservations_user_id` (`user_id`);

<<<<<<< HEAD
=======
ALTER TABLE `reservations`
    ADD KEY `reservations_representation_id` (`representation_id`);

>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
--
-- Contraintes pour la table `reservations`
--
ALTER TABLE `reservations`
    ADD CONSTRAINT `reservations_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;

<<<<<<< HEAD
=======
ALTER TABLE `reservations`
    ADD CONSTRAINT `reservations_representation_id` FOREIGN KEY (`representation_id`) REFERENCES `representations` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;

>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
