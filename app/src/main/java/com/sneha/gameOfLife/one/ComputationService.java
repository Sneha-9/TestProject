package com.sneha.gameOfLife.one;

public class ComputationService {


  public static void main(String[] args){
      int[][] a = {
              {1, 1, 0},
              {1, 0, 0},
              {0, 0, 0}
      };
        int m =3, n=3, count =0;
   System.out.println("start");
        int res[][] = new int[m][n];
        for(int i =0;i<m;i++){
            for(int j =0; j<n;j++){
                if((i+1< m) && a[i+1][j] == 1){
                    count++;
                }
                 if((j+1<n) && a[i][j+1] == 1){
                    count++;
                }
                 if((i+1<m) && (j+1 <n) && a[i+1][j+1] ==1){
                    count++;
                }
                 if((i-1>=0) &&(j-1 >=0)&& a[i-1][j-1] == 1){
                    count++;
                }
                 if((i-1>=0) && a[i-1][j] ==1){
                    count++;
                }
                 if((j-1>=0) && a[i][j-1] == 1){
                    count++;
                }
                 if((i-1>=0) && (j+1 < n) && a[i-1][j+1] ==1){
                    count++;
                }

                    if ((j - 1 >= 0) && (i + 1 < m) && a[i + 1][j - 1] == 1) {
                        count++;
                    }

              //  System.out.println(count);

                    if(count< 2){
                        res[i][j]= 0;
                    }
                    else if(count > 3){
                        res[i][j]= 0;
                    }
                    else if(count == 3){
                        res[i][j] = 1;
                    }

                else{
                   res[i][j] = a[i][j];
                    }
                count=0;
                }

            }

        for(int k =0; k<m;k++){
            for(int l=0;l<n;l++){
                System.out.print(res[k][l] + ", ");
            }
            System.out.println();
      }
        }
    }

