<<<<<<< HEAD
CREATE TABLE `user_role`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11) NOT NULL,
    `role_id` int(11) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
=======
CREATE TABLE `user_role` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `user_id` int(11) NOT NULL,
                             `role_id` int(11) NOT NULL,
                             PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a

--
-- Index pour la table `user_role`
--
<<<<<<< HEAD
ALTER TABLE `user_role`
    ADD KEY `user_role_user_id` (`user_id`);

ALTER TABLE `user_role`
    ADD KEY `user_role_role_id` (`role_id`);
=======
ALTER TABLE `user_role`ADD KEY `user_role_user_id` (`user_id`);

ALTER TABLE `user_role`ADD KEY `user_role_role_id` (`role_id`);
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a

--
-- Contraintes pour la table `user_role`
--
ALTER TABLE `user_role`
    ADD CONSTRAINT `user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `user_role`
    ADD CONSTRAINT `user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;
<<<<<<< HEAD
=======

>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
