class Matrix {
	private int row;
	private int col;
	private int[][] values;
	public Matrix(int rows,int cols){
		this.row = rows;
		this.col = cols;
		this.values = new int[this.row][this.col];
	}
	public void populate(int[] value){
		int couter = 0;
		for (int i =0;i<this.row;i++) {
			for (int j=0;j<this.col;j++) {
				this.values[i][j] = value[couter++];
			}
		}
	};

	public boolean equals(Object matrix){
		if(this==matrix) return true;
		if(!(matrix instanceof Matrix)) return false;
		Matrix newMatrix = (Matrix) matrix;
		for (int i =0;i<this.row;i++) {
			for (int j=0;j<this.col;j++) {
				if(this.values[i][j]!=newMatrix.values[i][j]){
					return false;
				}
			}
		};
		return true;
	}

	public int getValueAt(int row,int col){
		return this.values[row][col];
	};

	public String toString(){
		String str = "";
		for (int i=0;i<this.row;i++) {
			for (int j=0;j<this.col;j++) {
				str+=this.values[i][j]+"\t";
			}
			str+="\n";
		}
		return str;
	};
	

	public Matrix addTo(Matrix matrix){
		if(matrix.row!=this.row || matrix.col!=this.col) return new Matrix(0,0);
		Matrix addition  = new Matrix(this.row ,this.col);
		for (int i =0;i<this.row;i++){
			for (int j=0;j<this.col;j++)
				addition.values[i][j] = this.values[i][j]+matrix.values[i][j];

		}
		return addition;
	};
	public Matrix multiply(Matrix matrix){
		if(this.col!=matrix.row) return new Matrix(0,0);
		Matrix multiplyOfMatrix = new Matrix(this.row,matrix.col);
		for (int i=0;i<this.row;i++){
			for (int j=0;j<col;j++){
				int sum = 0;
				for (int k=0;k<this.col;k++) {
					sum+=this.values[i][k]*matrix.values[k][j];
				}
				multiplyOfMatrix.values[i][j] = sum;
			}
		}
		return multiplyOfMatrix;
	};


}