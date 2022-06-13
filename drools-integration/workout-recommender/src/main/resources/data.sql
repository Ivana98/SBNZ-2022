INSERT INTO authority (name) VALUES ('ROLE_USER');
INSERT INTO authority (name) VALUES ('ROLE_ADMIN');

INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);  --ROLE USER
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 1);  --ROLE USER
INSERT INTO user_authority (user_id, authority_id) VALUES (3, 2);  --ROLE ADMIN

INSERT INTO exerciser (id, name, surname, email, enabled, password, activity_level, body_type, age, height, weight) VALUES (1, 'Milica', 'Milic', 'milica@mail.com', true, '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'VERY_ACTIVE', 'ENDOMORPH', 22, 1.64, 65);
INSERT INTO exerciser (id, name, surname, email, enabled, password, activity_level, body_type, age, height, weight) VALUES (2, 'Milos', 'Mikic', 'milos@mail.com', true, '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'VERY_ACTIVE', 'ECTOMORPH', 26, 1.84, 82);

INSERT INTO admin (id, name, surname, email, enabled, password) VALUES (3, 'Pera', 'Petrovic', 'admin@mail.com', true, '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra');

INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (1, 'Cardio 1', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 45.0, 'HIGH', 'CARDIO');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (2, 'Cardio 2', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 45.0, 'HIGH', 'CARDIO');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (3, 'Cardio 3', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 30.0, 'MEDIUM', 'CARDIO');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (4, 'Cardio 4', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 30.0, 'LOW', 'CARDIO');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (5, 'Cardio 5', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 45.0, 'HIGH', 'CARDIO');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (6, 'Cardio 6', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 45.0, 'MEDIUM', 'CARDIO');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (7, 'Cardio 7', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 45.0, 'HIGH', 'CARDIO');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (8, 'Cardio 8', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 45.0, 'HIGH', 'CARDIO');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (9, 'Cardio 9', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 45.0, 'MEDIUM', 'CARDIO');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (10, 'Strength 1', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 45.0, 'LOW', 'STRENGTH');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (11, 'Strength 2', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 45.0, 'MEDIUM', 'STRENGTH');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (12, 'Strength 3', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 30.0, 'MEDIUM', 'STRENGTH');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (13, 'Strength 4', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 45.0, 'HIGH', 'STRENGTH');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (14, 'Strength 5', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 30.0, 'LOW', 'STRENGTH');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (15, 'Strength 6', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 30.0, 'MEDIUM', 'STRENGTH');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (16, 'Strength 7', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 30.0, 'HIGH', 'STRENGTH');
INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (17, 'Strength 8', 'https://www.youtube.com/embed/nM1ZIgMhy_4', 30.0, 'HIGH', 'STRENGTH');


INSERT INTO workout_equipment (workout_id, equipment) VALUES (1, 'DUMBBELLS');
INSERT INTO workout_equipment (workout_id, equipment) VALUES (5, 'EXPANDER');
INSERT INTO workout_equipment (workout_id, equipment) VALUES (5, 'DUMBBELLS');
INSERT INTO workout_equipment (workout_id, equipment) VALUES (7, 'EXPANDER');
INSERT INTO workout_equipment (workout_id, equipment) VALUES (8, 'EXPANDER');
INSERT INTO workout_equipment (workout_id, equipment) VALUES (8, 'DUMBBELLS');
INSERT INTO workout_equipment (workout_id, equipment) VALUES (13, 'EXPANDER');
INSERT INTO workout_equipment (workout_id, equipment) VALUES (13, 'DUMBBELLS');
INSERT INTO workout_equipment (workout_id, equipment) VALUES (12, 'DUMBBELLS');
INSERT INTO workout_equipment (workout_id, equipment) VALUES (14, 'DUMBBELLS');
INSERT INTO workout_equipment (workout_id, equipment) VALUES (14, 'EXPANDER');
INSERT INTO workout_equipment (workout_id, equipment) VALUES (14, 'RESISTANT_BAND');
INSERT INTO workout_equipment (workout_id, equipment) VALUES (15, 'RESISTANT_BAND');
INSERT INTO workout_equipment (workout_id, equipment) VALUES (16, 'RESISTANT_BAND');
INSERT INTO workout_equipment (workout_id, equipment) VALUES (16, 'DUMBBELLS');

INSERT INTO workout_mood (workout_id, mood) VALUES (1, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (1, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (1, 'BORED');
INSERT INTO workout_mood (workout_id, mood) VALUES (2, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (2, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (2, 'BORED');
INSERT INTO workout_mood (workout_id, mood) VALUES (3, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (3, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (3, 'BORED');
INSERT INTO workout_mood (workout_id, mood) VALUES (4, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (4, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (4, 'BORED');
INSERT INTO workout_mood (workout_id, mood) VALUES (5, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (5, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (5, 'BORED');
INSERT INTO workout_mood (workout_id, mood) VALUES (6, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (6, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (6, 'BORED');
INSERT INTO workout_mood (workout_id, mood) VALUES (7, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (7, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (7, 'BORED');
INSERT INTO workout_mood (workout_id, mood) VALUES (8, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (8, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (8, 'BORED');
INSERT INTO workout_mood (workout_id, mood) VALUES (9, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (9, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (9, 'BORED');
INSERT INTO workout_mood (workout_id, mood) VALUES (10, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (10, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (10, 'BORED');
INSERT INTO workout_mood (workout_id, mood) VALUES (11, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (11, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (11, 'BORED');
INSERT INTO workout_mood (workout_id, mood) VALUES (12, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (12, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (12, 'BORED');
INSERT INTO workout_mood (workout_id, mood) VALUES (13, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (13, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (13, 'BORED');
INSERT INTO workout_mood (workout_id, mood) VALUES (14, 'EXHAUSTED');
INSERT INTO workout_mood (workout_id, mood) VALUES (14, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (14, 'ANGRY_MOROSE');
INSERT INTO workout_mood (workout_id, mood) VALUES (14, 'BLUE');
INSERT INTO workout_mood (workout_id, mood) VALUES (14, 'STRESSED_ANXIOUS');
INSERT INTO workout_mood (workout_id, mood) VALUES (14, 'BORED');
INSERT INTO workout_mood (workout_id, mood) VALUES (15, 'EXHAUSTED');
INSERT INTO workout_mood (workout_id, mood) VALUES (15, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (15, 'ANGRY_MOROSE');
INSERT INTO workout_mood (workout_id, mood) VALUES (15, 'BLUE');
INSERT INTO workout_mood (workout_id, mood) VALUES (15, 'STRESSED_ANXIOUS');
INSERT INTO workout_mood (workout_id, mood) VALUES (15, 'BORED');
INSERT INTO workout_mood (workout_id, mood) VALUES (16, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (16, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (16, 'BLUE');
INSERT INTO workout_mood (workout_id, mood) VALUES (16, 'STRESSED_ANXIOUS');
INSERT INTO workout_mood (workout_id, mood) VALUES (17, 'EXHAUSTED');
INSERT INTO workout_mood (workout_id, mood) VALUES (17, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (17, 'ANGRY_MOROSE');
INSERT INTO workout_mood (workout_id, mood) VALUES (17, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (17, 'STRESSED_ANXIOUS');
INSERT INTO workout_mood (workout_id, mood) VALUES (17, 'BORED');
