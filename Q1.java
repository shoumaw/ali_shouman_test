public class Q1{

    public class Line{
        int x1;
        int x2;
        public Line(int x1, int x2){
            this.x1 = x1;
            this.x2 = x2;
        }
    }
    public Boolean areLinesOverlapping(Line line1, Line line2){
        // Most efficient way to check if two lines are overlapping is to check whether they are not overlapping
        // Assuming 
        if(line2.x2 < line1.x1 || line1.x2 < line2.x1){
            return false;
        }
        return true;
    }
}

