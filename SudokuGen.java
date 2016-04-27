import java.util.*;
public class SudokuGen {
	static int sudoku[][] = new int[4][4];
	public static void main(String[] args) {
		
		int n =1,k;
		Random r = new Random();
		
		for(int i=0;i<4;i++){//Generate basic sudoku matrix
			k=n;
			for(int j=0;j<4;j++){
				 if(k<=4){
		              sudoku[i][j]=k;
		              k++;
		          }else{
		           k=1;
		           sudoku[i][j]=k;
		           k++;
		          }
			}
			n=k+2;
			if(k==5)
			      n=3;
			if(n>4)
			     n=(n%4)+1;
		}
		
		
		//Swapping rows randomly within their blocks
		int k1 = 0, k2=1;//First block
		for(int i=0;i<2;i++){
			int check = r.nextInt(2);
			if(check==1){
				for(int j=0;j<4;j++)
				   {
				int temp=sudoku[k1][j];
				sudoku[k1][j]=sudoku[k2][j];
				sudoku[k2][j]=temp;
				   }
			}
			k1=2;//Second block
			k2=3;
		}
		
		
		//Swapping columns randomly within their blocks
		k1 = 0;//First column block
		k2 = 1;
		for(int i=0;i<2;i++){
			int check = r.nextInt(2);
			if(check==1){
				for(int j=0;j<4;j++)
				   {
				int temp=sudoku[j][k1];
				sudoku[j][k1]=sudoku[j][k2];
				sudoku[j][k2]=temp;
				   }
			}
			k1=2;//Second column block
			k2=3;
		}
		//int limit = r.nextInt(17); to remove arbitrary number of elements
		for(int a=0;a<8;a++){//Randomly remove 8 elements
			int i = r.nextInt(4);
			int j = r.nextInt(4);
			if(sudoku[i][j] == 0)
				a--;
			else
				sudoku[i][j] = 0;
		}
		
		for(int i=0;i<4;i++){//Printing the sudoku to console
			for(int j=0;j<4;j++){
				if(sudoku[i][j] == 0)
					System.out.print("( )\t");
				else
					System.out.print(" "+sudoku[i][j]+ "\t");
				if(i==1&&j==3)
					System.out.println("\n\n------------------------------------");
				else if(j==1)
					System.out.print("|\t");
				
			}
			System.out.println("");
		}
	}

}