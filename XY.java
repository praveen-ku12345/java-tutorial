public class XY
{
   public static void main(String args[])
   {  
    int INF=Integer.MAX_VALUE;
  int graph[][]={ 
                            {0, INF, 3, INF},
                           {2, 0, INF, INF},
                            {INF, 7, 0, 1},
                             {6, INF, INF, 0}
                           };
                      int n=graph.length;
int result[][]=new int[n][n];
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
{
result[i][j]=graph[i][j];
}
}
for(int k=0;k<n;k++){
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
{
  if(result[i][k]!=INF && result[k][j]!=INF && result[i][k]+result[k][j]<result[i][j])
result[i][j]=result[i][k]+result[k][j];
}
}
}
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
{
if(result[i][j]==INF)
System.out.print("INF"+"    ");
else
System.out.print(result[i][j]+"    ");
}
System.out.println();
}
}
}