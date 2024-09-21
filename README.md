**Team Description:**
  relife-e : 
  Name:  Anmol Saru Magar
  Student Id: 12180227
  Role: Project Manager, Screamer Front & Backend Developer

   CHROME-PLATED-METRO-WOLF : 
  Name: Caleb Davidson
  Student Id: 12110634
  Role: Technical Leader, Reccommendation developer, Security Implementation
  
   RoshanPhakamiPunmagar : 
  Name:  Roshan Phakami Punmagar
  Student Id: 12201590
  Role: Admin Frontend And Backend Developer
  
 Rutvi-12180614 : 
  Name:  Rutvi Patel
  Student Id: 12180614
  Role: Authentication and Authorization Designer, QA Tester

  
**Team Meetings**
Week 1: 
  Design video: https://youtu.be/z8gUuqz8OFw
  Project Managenment and Spring planning: https://youtu.be/3iv4Izh13jw?feature=shared
  Conflict Managenment: https://youtu.be/WNdcGgtp4lc


Week 2:
  Meetings: https://youtu.be/DiMTwOm-ysc

Week 3:
  Meetings:https://youtu.be/yNyc7JqQc7E

Week 4:
  Meetings: https://youtu.be/v7YRfAqWNmU
  Demonstration: https://youtu.be/-dUWSoZmVQ0
  Final Testing and Discussion: https://youtu.be/bwN3kgIxsZY

**Peer Programming:**
Roshan Phakami Magar & Amnol Saru Magar Week 1: https://youtu.be/E7fQVZGBHC0
Roshan Phakami Magar & Amnol Saru Magar Week 2: https://youtu.be/IxIJlfpAZ3Y
Caleb & Rutvi Week 2 https://youtu.be/g5McxsWBqJs

Anmol Saru Magar & Caleb Davidson: https://youtu.be/JEEgCJa7jYY

Non Functional Designs:
Micro Service 1:
![image](https://github.com/user-attachments/assets/60266c1d-8103-4742-855b-5e1e290d10cc)

Micro Service 1:
![image](https://github.com/user-attachments/assets/9f67fc9e-b9fd-4581-8fa7-8aa4ba999c96)

Micro Service 1: 
![image](https://github.com/user-attachments/assets/0df1f78d-e2a0-4553-9ddb-3885ba4db969)

Erd Week 3: Team
![image](https://github.com/user-attachments/assets/1ed221c6-35b9-4745-b3c9-441ccab5b50b)

Use Case Week 3 :Team
![image](https://github.com/user-attachments/assets/64ba4b2f-1e3c-4d50-bf18-ab61adebfed7)

Use Case Week 3: Team
![image](https://github.com/user-attachments/assets/477743ee-9d19-4ef5-9dcf-78066c8da4cf)

**Test Cases**
Admin Credentails:
email : anmol@gmail.com 
password : anmol123

email : roshan@gmail.com
password: roshan123

User Credentials

email : caleb@gmail.com
password: caleb123

email : rutvi@gmail.com
password: rutvi123

User Story
•	As a Admin, I can can block Movies.
•	As a Admin, I can can unblock Movies.
•	As a Admin, I can block users.
•	As a Admin, I can unblock users.
•	As a user can access web app
•	As user, I can see recommendation
•	As user, I can watch Movies
•	As user, I can add movie in watchlist
•	As user, I can remove movie in watchlist
Functional Requirements
•	User Registration and Authentication: The system allow to user can register, login and logout securely
•	Recommendations: The application provide every time random movie recommendations.
•	Watchlist: Users can add, remove, and view movies in their watchlist.
•	Admin : Admin can be able to Block/unblock user and also block/unblock Movies.
•	Movies: User can watch Movie.
Non-Functional Requirements
•	Performance: Under typical demand, the program should reply to user queries in two seconds.
•	Security: The system must prevent unwanted access and all user data must be encrypted.
•	Usability: the user interface should be simple to use and accessible.

Installation Guides
-	Unzip Spring2Assignment folder.
-	Right click open folder in netbeans.
-	Select all the project admin, DatabseDao,Recommendation, Screamer, screamerWebApp in netbeans.
-	Click on Open Project and run project.




Sequence for run microservices
1) Server
2) DatabaseDao
3) Admin
4) Recommendation
5) ScreamerWebApp
6) Screamer

 
![image](https://github.com/user-attachments/assets/3d25c160-f927-4e39-af32-3137e0671a41)



Testing – Test Plan and Test results
•	http://localhost:8761
 ![image](https://github.com/user-attachments/assets/6a5449aa-b18c-410b-860a-afe9c697bcc1)

•	Open Screamer web app its redirect login page. Login as a user.
Email: rutvi@gmail.com
Pwd : rutvi123

![image](https://github.com/user-attachments/assets/21372d38-ca56-4593-bfe4-3f5c88ecd3e4)

•	Welcome screen.
![image](https://github.com/user-attachments/assets/9252f044-dbf2-4909-813e-cbce06429a0b)

 
•	Click on View all Movies for view all movie
 ![image](https://github.com/user-attachments/assets/b4e1bd32-5a21-4cf1-97c0-7b9f14591281)

•	Movie Page
 
![image](https://github.com/user-attachments/assets/2b61f121-579c-4ad7-9ffb-c4744747b541)

 ![image](https://github.com/user-attachments/assets/2cca2723-4461-4853-835b-017a7b48b9ea)

•	Recommendation Page - As user, I can see recommendation
![image](https://github.com/user-attachments/assets/49fad62e-b644-4209-8c8c-9e65443416c0)

 
•	My watchlist page before add movie - As user, I can add movie in watchlist
 
![image](https://github.com/user-attachments/assets/09a437dc-35d0-41a7-82f4-56208da15ec9)

•	Movie add into watch list 
![image](https://github.com/user-attachments/assets/6de9afa7-f516-4ff1-8a8d-91f3eb9083cc)

 
•	My watchlist after add movies
 ![image](https://github.com/user-attachments/assets/63d12f10-29f2-4d43-9cfd-157a141f3687)


•	As user, I can remove movie in watchlist
 
![image](https://github.com/user-attachments/assets/45087b24-2138-44b4-b93c-8f98a3b154de)

•	Login as Admin
Email : anmol@gmail.com
Pwd: anmol123
 
![image](https://github.com/user-attachments/assets/d3b6e65e-da2a-4ecc-88f7-4c81c1518013)




•	As a Admin, I can block users.
 ![image](https://github.com/user-attachments/assets/fa6eb2ac-3ca7-4175-81d8-d11d666b678e)


•	As a Admin, I can unblock users.
 
![image](https://github.com/user-attachments/assets/5fb7586b-37be-41e0-8a6c-2b5c31985289)



•	As a Admin, I can block users.
 ![image](https://github.com/user-attachments/assets/368f5ff2-9c52-445e-b2f1-90346a240915)

•	As a Admin, I can unblock users.
 
![image](https://github.com/user-attachments/assets/8937555f-1071-46d4-bc9d-1f5633f446ce)

![image](https://github.com/user-attachments/assets/541d5705-1be8-4fd9-bfff-43e6f830b8be)


