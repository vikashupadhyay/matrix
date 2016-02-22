class Matrix {
	private final int row;
	private final int col;
	private int[][] values;
	public Matrix(int rows,int cols){
		row = rows;
		col = cols;
		values = new int[row][col];
	}
	public void populate(int[] value){
		int couter = 0;
		for (int i =0;i<row;i++) {
			for (int j=0;j<col;j++) {
				values[i][j] = value[couter++];
			}
		}
	};

	public boolean equals(Object matrix){
		if(this==matrix) return true;
		if(!(matrix instanceof Matrix)) return false;
		Matrix newMatrix = (Matrix) matrix;
		for (int i =0;i<row;i++) {
			for (int j=0;j<col;j++) {
				if(values[i][j]!=newMatrix.values[i][j]){
					return false;
				}
			}
		};
		return true;
	}

	public int getValueAt(int row,int col){
		return values[row][col];
	};

	public String toString(){
		String str = "";
		for (int i=0;i<row;i++) {
			for (int j=0;j<col;j++) {
				str+=values[i][j]+"\t";
			}
			str+="\n";
		}
		return str;
	};
	

	public Matrix addTo(Matrix matrix){
		if(matrix.row!=row || matrix.col!=col) return new Matrix(0,0);
		Matrix addition  = new Matrix(row ,col);
		for (int i =0;i<row;i++){
			for (int j=0;j<col;j++)
				addition.values[i][j] = values[i][j]+matrix.values[i][j];

		}
		return addition;
	};

	public Matrix multiply(Matrix matrix){
		if(col!=matrix.row) return new Matrix(0,0);
		Matrix multiplyOfMatrix = new Matrix(row,matrix.col);
		for (int i=0;i<row;i++){
			for (int j=0;j<col;j++){
				int sum = 0;
				for (int k=0;k<col;k++) {
					sum+=values[i][k]*matrix.values[k][j];
				}
				multiplyOfMatrix.values[i][j] = sum;
			}
		}
		return multiplyOfMatrix;
	};

	public Matrix getSubMatrix(int position){
		Matrix subMatrix = new Matrix(row-1,col-1);
		int[] allValues = new int[(row-1)*(col-1)];
		int counter =0;
		for (int i=0;i<row;i++) {
			for (int j=0;j<col;j++){
				if(i!=0&&j!=position){
					allValues[counter]=this.values[i][j]; 
				counter++;
				}
			}
		};
		subMatrix.populate(allValues);
		return subMatrix;
	}
	public int findDeterminant(){
		int result=0;
		if(col!=row) return result;
		if(col==2 && row==2)
			return (this.values[0][0]*this.values[1][1]-this.values[0][1]*this.values[1][0]);
		for (int i=0;i<col;i++) {
			result += Math.pow((-1),i)*values[0][i]*getSubMatrix(i).findDeterminant();
		}
		return result;
	}

}