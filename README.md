# bucket-fill-application
A console based application to draw canvas, line, box and bucket fill functionality.

-------------------
# Requirements
Java 11
Maven

-------------------
# Frameworks used
Junit 5 for unit testing
Lombok to increase readability of source code and  to not write boilerplate code.

------------------
# Commands

Command 		Description
C w h           Should create a new canvas of width w and height h.

L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                horizontal or vertical lines are supported. Horizontal and vertical lines
                will be drawn using the 'x' character.
                
R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.
                
B x y c         Should fill the entire area connected to (x,y) with "colour" c. The behaviour of this is the same as that of the "bucket fill" 	
                tool in paint programs.

Q               Should quit the program.

-------------------------
# Assumptions : 
1. Boundaries color cannot be overridden(H-Border is represented by '-' and V-Border is represented by '|'
2. Lines can be drawn vertically or horizontally. Diagonal lines are not covered in this application. Lines are represented by 'x'.
4. Console coordinate : (x,y) origin coordinate is the left top corner. X coordinate grows horizontally towards right. whereas y coordinate moves vertically towards bottom of console.     
  
 ------------------------
 # Approach
 1. Used queue based approach(DFS) rather than stack based(BFS) as the canvas size can be huge.
 
 ------------------------
 # Build and deploy
 **Build**  - mvn clean compile install
 **Deploy** - Navigate to target folder. There will be jar(**bucket-fill-application-1.0-SNAPSHOT.jar**).
              Use command **java -jar bucket-fill-application-1.0-SNAPSHOT.jar** to execute application.
 **Test**   - mvn test
  
