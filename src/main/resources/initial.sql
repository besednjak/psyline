INSERT INTO patients VALUES
    ('pJuanetes', '1999-12-03', 'pjuanetes@uade.edu.ar', 'Juanetes',  'Pepito'),
    ('juanito01', '2004-02-22', 'juanito01@uade.edu.ar', 'González', 'Juan'),
    ('maria22', '2003-10-08', 'maria22@uade.edu.ar', 'Rodríguez', 'María'),
    ('andres_89', '2001-09-12', 'andres_89@uade.edu.ar', 'Martínez', 'Andrés'),
    ('sofialopez', '2000-11-03', 'sofialopez@uade.edu.ar', 'López', 'Sofía'),
    ('ale_perez', '2002-05-18', 'ale_perez@uade.edu.ar', 'Pérez', 'Alejandro'),
    ('v.gomez', '2001-08-14', 'v.gomez@uade.edu.ar', 'Gómez', 'Valentina'),
    ('carlos.s', '2000-02-01', 'carlos.s@uade.edu.ar', 'Sánchez', 'Carlos'),
    ('lfernandez', '1997-11-20', 'lfernandez@uade.edu.ar', 'Fernández', 'Laura'),
    ('gabrieltorres', '1997-04-04', 'gabrieltorres@uade.edu.ar', 'Torres', 'Gabriel'),
    ('bella_ram', '2002-09-29', 'bella_ram@uade.edu.ar', 'Ramírez', 'Isabella'),
    ('pedromendo', '2003-03-27', 'pedromendo@uade.edu.ar', 'Mendoza', 'Pedro'),
    ('cami_vargas', '2001-06-21', 'cami_vargas@uade.edu.ar', 'Vargas', 'Camila'),
    ('javier.castro', '2000-12-10', 'javier.castro@uade.edu.ar', 'Castro', 'Javier'),
    ('nataliah', '1999-01-15', 'nataliah@uade.edu.ar', 'Herrera', 'Natalia'),
    ('diegosilva', '2001-06-14', 'diegosilva@uade.edu.ar', 'Silva', 'Diego'),
    ('ana23', '1998-08-03', 'ana23@uade.edu.ar', 'Torres', 'Ana'),
    ('dancord', '1996-06-22', 'dancord@uade.edu.ar', 'Córdoba', 'Daniel'),
    ('gabiguz', '1995-03-15', 'gabiguz@uade.edu.ar', 'Guzmán', 'Gabriela'),
    ('luiso', '2002-11-26', 'luiso@uade.edu.ar', 'Ortiz', 'Luis'),
    ('vicky.rios', '2001-09-05', 'vicky.rios@uade.edu.ar', 'Ríos', 'Victoria');

INSERT INTO therapists
VALUES
    ('jperez', 'IN_PERSON', 5000,'', '1992-03-15', 'jperez@uade.edu.ar', 'Pérez', '0112345678', 'Juan', '01112345678','C:\\Users\\samsung\\OneDrive - Fundación UADE\\Desktop\\UADE\\2023 1c\\3SEMI', 'PARQUE_AVELLANEDA', 'PSYCHOANALYSIS'),
    ('mlopez', 'VIRTUAL', 4500,'', '1985-09-10', 'mlopez@uade.edu.ar', 'López', '0223456789', 'María', '01123456789','C:\\Users\\samsung\\OneDrive - Fundación UADE\\Desktop\\UADE\\2023 1c\\3SEMI', 'BELGRANO', 'COGNITIVE_BEHAVIORAL_THERAPY'),
    ('rgonzalez', 'HYBRID', 4750,'', '1990-06-25', 'rgonzalez@uade.edu.ar', 'González', '0334567890', 'Roberto', '01134567890','C:\\Users\\samsung\\OneDrive - Fundación UADE\\Desktop\\UADE\\2023 1c\\3SEMI', 'BELGRANO', 'GROUP_THERAPY'),
    ('fsanchez', 'VIRTUAL', 5000,'', '1988-11-02', 'fsanchez@uade.edu.ar', 'Sánchez', '0445678901', 'Fernanda', '01145678901','C:\\Users\\samsung\\OneDrive - Fundación UADE\\Desktop\\UADE\\2023 1c\\3SEMI', 'ALMAGRO', 'FAMILY_THERAPY'),
    ('pgomez', 'IN_PERSON',6500,'', '1994-04-18', 'pgomez@uade.edu.ar', 'Gómez', '0556789012', 'Pablo', '01156789012', 'C:\\Users\\samsung\\OneDrive - Fundación UADE\\Desktop\\UADE\\2023 1c\\3SEMI','ALMAGRO', 'PSYCHOANALYSIS'),
    ('cfernandez', 'HYBRID',5750,'', '1991-07-05', 'cfernandez@uade.edu.ar', 'Fernández', '0667890123', 'Carolina', '01167890123','C:\\Users\\samsung\\OneDrive - Fundación UADE\\Desktop\\UADE\\2023 1c\\3SEMI', 'AGRONOMIA', 'COGNITIVE_BEHAVIORAL_THERAPY'),
    ('mmartinez', 'VIRTUAL', 5500,'', '1987-12-22', 'mmartinez@uade.edu.ar', 'Martínez', '0779012345', 'Miguel', '01178901234','C:\\Users\\samsung\\OneDrive - Fundación UADE\\Desktop\\UADE\\2023 1c\\3SEMI', 'PARQUE_AVELLANEDA', 'GROUP_THERAPY'),
    ('lgarcia', 'IN_PERSON',6000,'', '1993-08-09', 'lgarcia@uade.edu.ar', 'García', '0880123456', 'Lucía', '01189012345','C:\\Users\\samsung\\OneDrive - Fundación UADE\\Desktop\\UADE\\2023 1c\\3SEMI', 'AGRONOMIA', 'FAMILY_THERAPY'),
    ('romigonzalez', 'HYBRID',4500,'', '1989-02-26', 'rgonzalez@uade.edu.ar', 'González', '0991234567', 'Romina', '01190123456','C:\\Users\\samsung\\OneDrive - Fundación UADE\\Desktop\\UADE\\2023 1c\\3SEMI', 'BELGRANO', 'PSYCHOANALYSIS'),
    ('mgomez', 'IN_PERSON',5250,'', '1990-05-17', 'mgomez@uade.edu.ar', 'Gómez', '0102345678', 'Marcelo', '01101234567','C:\\Users\\samsung\\OneDrive - Fundación UADE\\Desktop\\UADE\\2023 1c\\3SEMI', 'BELGRANO', 'COGNITIVE_BEHAVIORAL_THERAPY');

INSERT INTO THERAPY_TREATMENTS
VALUES
    (1, 'ANXIETY','jperez'),
    (2, 'STRESS','jperez');

INSERT INTO quotes VALUES
                       (1,'Aunque nadie puede volver atrás y hacer un nuevo comienzo, cualquiera puede comenzar a partir de ahora y crear un nuevo final. Carl Bard'),
                       (2,'La felicidad no puede ser ganada, no es una propiedad. Es la experiencia espiritual de vida de cada minuto con amor, gracia y gratitud. Denis Waitley'),
                       (3,'No conozco el secreto del éxito, pero el secreto del fracaso es procurar seguir siempre la voluntad de los otros.'),
                       (4,'Acepta la responsabilidad de tu vida. Date cuenta que tú eres quien va a llegar a donde quiere ir, nadie más. Les Brown'),
                       (5,'Todos caemos al suelo en algún momento. Es la forma en que te levantas, ese es el verdadero desafío. ¿No es así? Madonna'),
                       (6,'No hay nada imposible, porque los sueños de ayer son las esperanzas de hoy y pueden convertirse en realidad mañana.'),
                       (7,'Si no sabes, te enseño. Si no puedes, te ayudo. Pero si no quieres, lo siento, pero nada puedo hacer por ti.'),
                       (8,'Si tú no construyes tu sueño, alguien va a contratarte para que le ayudes a construir el suyo. Dhirubhai Ambani'),
                       (9,'Lo único que se interpone entre ti y tu sueño, es la voluntad de intentarlo y la creencia de que en realidad es posible. Joel Brown'),
                       (10,'Los desafíos son los que hacen la vida interesante, y superarlos es lo que hace la vida significativa. Joshua J. Marino'),
                       (11,'La única manera de hacer un gran trabajo, es amar lo que haces. Si no lo has encontrado, sigue buscando. No te conformes. Steve Jobs'),
                       (12,'La vida es como fotografía. Necesita los negativos para desarrollarse.'),
                       (13,'Estoy agradecido por todos los que me dijeron NO. Es gracias a ellos estoy siendo yo mismo. Albert Einstein'),
                       (14,'No juzgues cada día por la cosecha que has obtenido, sino por las semillas que has plantado. Robert Louis Stevenson'),
                       (15,'Dondequiera que vayas, sin importar el clima, siempre lleva su propio sol. La actitud lo es todo… D’Angelo'),
                       (16,'Si la oportunidad no llama, construye una puerta. Milton Berle'),
                       (17,'Todos nuestros sueños pueden hacerse realidad si sólo tenemos el coraje de perseguirlos. Walt Disney'),
                       (18,'Amarse a uno mismo es el comienzo de un romance de toda la vida. Oscar Wilde');

