
drop schema donContainer;
create schema donContainer;
use donContainer;

SELECT * FROM doncontainer.app_user;
SELECT * FROM doncontainer.section;
SELECT * FROM doncontainer.type;
SELECT * FROM doncontainer.style;
SELECT * FROM doncontainer.proyect;
SELECT * FROM doncontainer.photo;
SELECT * FROM doncontainer.proyect_slide;
SELECT * FROM doncontainer.proyect_style;
SELECT section_id FROM doncontainer.proyect  WHERE proyect.id = 8;
SELECT cover_id FROM doncontainer.proyect  WHERE proyect.id = 8;
SELECT proyect_photos FROM doncontainer.proyect  WHERE proyect.id = 8;





delete proyect FROM proyect where id = 27;
SELECT * FROM section se, style st, type ty WHERE se.id = st.id;

INSERT INTO `doncontainer`.`section` (`id`, `name`) VALUES ('2', 'inspiracion');
INSERT INTO `doncontainer`.`section` (`id`, `name`) VALUES ('3', 'alquileres');
INSERT INTO `doncontainer`.`section` (`id`, `name`) VALUES ('4', 'proyectos');
INSERT INTO `doncontainer`.`section` (`id`, `name`) VALUES ('5', 'inicio');
INSERT INTO `doncontainer`.`type` (`id`, `name`) VALUES ('7', 'container');
INSERT INTO `doncontainer`.`type` (`id`, `name`) VALUES ('8', 'modulo');
INSERT INTO `doncontainer`.`type` (`id`, `name`) VALUES ('9', 'otros');
INSERT INTO `doncontainer`.`type` (`id`, `name`) VALUES ('10', 'camion');
INSERT INTO `doncontainer`.`style` (`id`, `name`) VALUES ('12', 'casa');
INSERT INTO `doncontainer`.`style` (`id`, `name`) VALUES ('13', 'baño');
INSERT INTO `doncontainer`.`style` (`id`, `name`) VALUES ('14', 'escuela');
INSERT INTO `doncontainer`.`style` (`id`, `name`) VALUES ('15', 'bar');







