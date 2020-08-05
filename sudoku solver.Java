import java.util.*;  
import java.util.ArrayList;

public class DeleteMe {
	
	public static void main(String args[]){

		//create a scanner and ask the user to enter a puzzle
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a Suduko Puzle: ");  
		String str= sc.nextLine();

		//remove spaces and , 
		str = str.replaceAll("[,]","");str = str.replaceAll("[ ]","");
		
		//create our two dimentional array using the data and fill it using the inputed string value
		int [][] puzzle = new int[9][9];
		for(int i=0;i<9;i++){for (int j=0;j<9;j++){puzzle[i][j] = Integer.parseInt(Character.toString(str.charAt(((i*9)+j))));}} 

		//print out the puzzle
		for(int i=0;i<9;i++){for(int j=0;j<9;j++){System.out.print(puzzle[i][j]+"  ");}System.out.println("");}


		//loop through all squares f amount of times
		for(int f = 0;f<100;f++){
			//now we take every square and check if we only have 1 missing valuie 
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){

					//make an arraylist with possible values, we will try to remove all posibilities except 1
					ArrayList<Integer> checklist = new ArrayList<Integer>();
					checklist.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
				
					//check to see if value needs to be updated
					if(puzzle[i][j] == 0){

						//loop through straight lines up and down
						for (int x=0;x<9;x++){if (checklist.contains(puzzle[x][j])){checklist.remove(Integer.valueOf(puzzle[x][j]));}}
						for (int y=0;y<9;y++){if (checklist.contains(puzzle[i][y])){checklist.remove(Integer.valueOf(puzzle[i][y]));}}

						//xpos and y pos are the centre values of the square the 
						int xpos,ypos;

						//here we determine what square the value is in and see what values we need to check
						if(i%3 == 0){xpos = i+1;}
							else if(i%3 == 2){xpos = i-1;}
								else{xpos = i;}

						if(j%3 == 0){ypos = j+1;}
							else if(j%3 == 2){ypos = j-1;}
								else{ypos = j;}

						for(int a=-1;a<2;a++){
							for(int b=-1;b<2;b++){
								if (checklist.contains(puzzle[xpos+a][ypos+b])){checklist.remove(Integer.valueOf(puzzle[xpos+a][ypos+b]));}
							}
						}

						if(checklist.size() == 1){puzzle[i][j] = checklist.get(0);
							System.out.println("");
							for(int ii=0;ii<9;ii++){for(int jj=0;jj<9;jj++){System.out.print(puzzle[ii][jj]+"  ");}System.out.println("");}
						}
					}
				}
			}
		}
	}
}