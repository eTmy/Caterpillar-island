# Caterpillar-island
Краткое описание
-----------------
Программа симмулирует развитие жизни на острове по дням.
Остров разделен на биомы (ячейки) с животными и растениями. Вместительность каждого биома 
ограничена по количеству созданных видов обьектов.  
Все обьекты имеют свои уникальные характеристки. Живые существа делятся на травоядных и хищников со всеми
вытекающими из этого особенностями. Задача каждого существа постараться
прожить как можно большее количество дней. Для этого ему необходимо перемещаться по острову
в поисках пропитания и партнера для размножения. Существо умирает в случае если оно не может найти пропитание в течении нескольких
дней, либо стало жертвой охоты другого объекта.

# Пример работы программы
****************************************
World is created!  
Size: 5 x 5  
Animal population: 26813  
Plant population: 2583  
Max days: 50  
****************************************
Day: 0  
294 objects were eaten  
0 animals died of hunger  
0 animals were born  
Animal population: 26813  
Plant population: 3514  
****************************************
Day: 1  
689 objects were eaten  
0 animals died of hunger  
40 animals were born  
Animal population: 26559  
Plant population: 3887  
****************************************
Day: 2  
300 objects were eaten  
0 animals died of hunger  
220 animals were born  
Animal population: 26090  
Plant population: 4132  
****************************************
Day: 3  
25098 objects were eaten  
25074 animals died of hunger  
54 animals were born  
Animal population: 25844  
Plant population: 4281  
****************************************
Day: 4  
101 objects were eaten  
76 animals died of hunger  
24 animals were born  
Animal population: 770  
Plant population: 4391  
****************************************
Day: 5  
58 objects were eaten  
35 animals died of hunger  
35 animals were born  
Animal population: 704  
Plant population: 4435  
****************************************
Day: 6  
474 objects were eaten  
465 animals died of hunger  
35 animals were born  
Animal population: 681  
Plant population: 4492  
****************************************
Day: 7  
51 objects were eaten  
49 animals died of hunger  
6 animals were born  
Animal population: 213  
Plant population: 4553  
****************************************
Day: 8  
30 objects were eaten  
26 animals died of hunger  
1 animals were born  
Animal population: 163  
Plant population: 4567  
****************************************
Day: 9  
61 objects were eaten  
61 animals died of hunger  
0 animals were born  
Animal population: 133  
Plant population: 4591  
****************************************
Day: 10  
56 objects were eaten  
56 animals died of hunger  
0 animals were born  
Animal population: 72  
Plant population: 4654  
****************************************
Day: 11  
10 objects were eaten  
10 animals died of hunger  
0 animals were born  
Animal population: 16  
Plant population: 4674  
****************************************
Day: 12  
2 objects were eaten  
2 animals died of hunger  
0 animals were born  
Animal population: 6  
Plant population: 4703  
****************************************
Day: 13  
2 objects were eaten  
2 animals died of hunger  
0 animals were born  
Animal population: 4  
Plant population: 4732  
****************************************
Day: 14  
2 objects were eaten  
2 animals died of hunger  
0 animals were born  
Animal population: 2  
Plant population: 4740  
****************************************
Your colony has lasted 15 days!  
THE END!  
****************************************

Краткое описание классов
------------------------ 

* В пакете `com.etmy.caterpillarisland.objects` хранится основная иерархия классов создаваемых объектов

* В пакете `com.etmy.caterpillarisland.db` находится класс GameObjects реализующий в себе базу данных для хранения 
созданных объектов и методов для взаимодействия с ними.

* В пакете `com.etmy.caterpillarisland.tasks` хранятся классы для многопоточной работы приложения

* Пакет `com.etmy.caterpillarisland.services` содержит набор сервисов:

   * `ClassFinder`     - сервис для поиска классов в пакетах.

   * `GameHandler`     - содержит обработчики игровых событий.

   * `GameInitializer` - содержит точку входа в приложение. иницализирует основные настройки и генерацию мира.

   * `Settings`        - содержит настройки приложения.

   * `Statistic`       - отвечает за хранение статистики и её вывод в консоль.

   * `Survival`        - хранит взаимотношение между классами (вероятность успешной охоты).
