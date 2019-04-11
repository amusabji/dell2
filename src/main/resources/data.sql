
insert or ignore into users values (null, 'admin', 'password', 'SUPER_ADMIN');


-- test data
-- generated at: https://www.generatedata.com/
INSERT OR ignore INTO clients(id,name,phone_number,address)
VALUES
  (NULL, "Cole A.", "3944685477", "2105 Magna. St."),
  (NULL, "Griffin", "5139812377", "P.O. Box 253, 6056 Quisque Avenue"),
  (NULL, "Molly", "1861187576", "329-2289 Malesuada St."),
  (NULL, "Teegan", "9395392362", "Ap #772-5014 Tempus Avenue"),
  (NULL, "Griffin", "2819945427", "332-7046 Ipsum St."),
  (NULL, "Ray", "2448714334", "149 Luctus Road"),
  (NULL, "Norman", "6633727327", "Ap #320-7048 Diam. Avenue"),
  (NULL, "Regan", "8927322682", "Ap #455-3573 Bibendum Street"),
  (NULL, "Cheyenne", "4599462371", "P.O. Box 730, 5260 Gravida Avenue"),
  (NULL, "Hunter", "4467123484", "9453 Odio Road"),
  (NULL, "Sylvester P.", "4222883188", "P.O. Box 510, 7093 Erat St."),
  (NULL, "Adrian", "7579466291", "Ap #457-1440 Ut St."),
  (NULL, "Urielle", "8958688134", "967-3543 Ante. St."),
  (NULL, "Janna", "3835919539", "Ap #516-2098 Integer St."),
  (NULL, "Cruz", "3144637288", "P.O. Box 997, 3864 Arcu Av."),
  (NULL, "Alec", "1379525352", "2078 Vitae Rd."),
  (NULL, "Raymond", "3611646823", "3058 Semper, Road"),
  (NULL, "Robin", "5246344744", "531-4104 Purus. Av."),
  (NULL, "Porter", "4318159139", "7314 Euismod St."),
  (NULL, "Helen S.", "6239462636", "Ap #595-5944 Eget Road"),
  (NULL, "Melissa", "4135297699", "P.O. Box 257, 6884 Justo. St."),
  (NULL, "Vincent", "4318584662", "882-1295 Enim. Road"),
  (NULL, "Elizabeth", "5871456373", "6635 A St."),
  (NULL, "Cody", "4585353873", "Ap #940-683 Magnis Road"),
  (NULL, "Addison", "2112213275", "Ap #232-8681 Elit St."),
  (NULL, "Daria", "8179745693", "Ap #549-8266 In, Street"),
  (NULL, "Carson", "6398966861", "Ap #123-3240 Ante Street"),
  (NULL, "Vanna", "7278294947", "289-8820 Donec Road"),
  (NULL, "Idona", "9632939425", "9946 Euismod Rd."),
  (NULL, "Diana", "6199754226", "999-402 Consequat Rd.");

 INSERT OR ignore INTO pets
  (id,name,gender,altered,client_id)
VALUES
  (NULL, "Gum Drop", "Female", 0, 1),
  (NULL, "Honey Bun", "Male", 0, 2),
  (NULL, "Bossman", "Female", 1, 3),
  (NULL, "Cupcake", "Female", 1, 4),
  (NULL, "Boo", "Male", 1, 5),
  (NULL, "Felix", "Male", 1, 6),
  (NULL, "Kiwi", "Male", 1, 7),
  (NULL, "Minx", "Female", 1, 8),
  (NULL, "Captain", "Female", 1, 9),
  (NULL, "Snugglekins", "Male", 0, 10),
  (NULL, "Snickers", "Male", 0, 11),
  (NULL, "Butterfingers", "Male", 0, 12),
  (NULL, "Chubby", "Female", 1, 13),
  (NULL, "Anchor", "Female", 0, 14),
  (NULL, "Bambi", "Female", 1, 15),
  (NULL, "Sweet Prince", "Male", 0, 16),
  (NULL, "Sweetums", "Female", 0, 17),
  (NULL, "Marshmallow", "Female", 0, 18),
  (NULL, "Better Half", "Female", 1, 19),
  (NULL, "Apple", "Female", 0, 20),
  (NULL, "Tiger", "Female", 1, 21),
  (NULL, "Snugglekins", "Female", 0, 22),
  (NULL, "Lucky", "Male", 0, 23),
  (NULL, "Lion King", "Female", 1, 24),
  (NULL, "Casanova", "Female", 1, 25),
  (NULL, "Keroppi", "Female", 0, 26),
  (NULL, "Baby boy", "Female", 1, 27),
  (NULL, "Max", "Female", 1, 28),
  (NULL, "My Everything", "Female", 1, 29),
  (NULL, "Captain", "Female", 1, 30),
  (NULL, "Chubby bunny", "Female", 0, 1),
  (NULL, "Bossman", "Female", 1, 2),
  (NULL, "Mango", "Female", 0, 2),
  (NULL, "Gummy Bear", "Female", 0, 5),
  (NULL, "Tater Tot", "Male", 0, 10);
 
 INSERT OR ignore INTO appointments
  (id,client_id,pet_id,appt_time,appt_date,appt_type)
VALUES
  (NULL, 1, 1, "10:30", "2019-05-03", "Checkup"),
  (NULL, 4, 4, "09:30", "2019-06-20", "Vaccinations"),
  (NULL, 6, 6, "09:00", "2019-07-02", "Checkup"),
  (NULL, 7, 7, "11:00", "2019-07-02", "Microchip");