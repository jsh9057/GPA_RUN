# GPA_RUN
java project
개발날짜 2016/10 ~ 2016/12
---------------------------------------------

- GPA_RUN ( Grade Point Average RUN)

-실행화면-

![image](https://user-images.githubusercontent.com/31503178/64944648-cc4a3a00-d8a9-11e9-8557-ad3e459a31ea.png)
![image](https://user-images.githubusercontent.com/31503178/64944663-d3714800-d8a9-11e9-9ffb-65bb0dcb3285.png)
![image](https://user-images.githubusercontent.com/31503178/64944671-d66c3880-d8a9-11e9-8dfc-003907f1946d.png)
![image](https://user-images.githubusercontent.com/31503178/64944778-16cbb680-d8aa-11e9-9a12-a928cfe259e8.png)
![image](https://user-images.githubusercontent.com/31503178/64944682-dcfab000-d8a9-11e9-9b73-e32ebf0f54cd.png)
![image](https://user-images.githubusercontent.com/31503178/64944688-dff5a080-d8a9-11e9-945f-a820a4e1f646.png)
![image](https://user-images.githubusercontent.com/31503178/64944813-277c2c80-d8aa-11e9-8c30-43d09be38fda.png)
![image](https://user-images.githubusercontent.com/31503178/64944822-2ba84a00-d8aa-11e9-9985-71847516f30b.png)
![image](https://user-images.githubusercontent.com/31503178/64944829-306cfe00-d8aa-11e9-9591-19832cd2926d.png)
![image](https://user-images.githubusercontent.com/31503178/64945290-2dbed880-d8ab-11e9-9098-b033fc51bf1f.png)

- Class Architecture  
 GPA_RUN은 Login, Information, Game(Rank), Ending으로 4개의 역할로 나누었습니다. 역할의 따라 각각 페이지는 Scene Builder에서 만들어낸 View역할을 해줄 fxml파일과 JavaFX에서 연동해주는 Override Class, Controller역할을 해줄 Control Class로 나뉘어져 있습니다.
Main에서 선언한 Stage에 Login_Page ,Game_Page, Information_Page, Ending_Page를 Application(main) 올려 게임을 진행 할 수 있도록 합니다.
