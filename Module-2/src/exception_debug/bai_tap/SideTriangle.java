package exception_debug.bai_tap;

public class SideTriangle {
    public SideTriangle(int sideA, int sideB, int sideC) throws ILLegalTriangleException{
        if (sideA < 0|| sideB < 0|| sideC < 0){
            String error = "The side can not less than 0!";
            throw new ILLegalTriangleException(error);
        }
        if (sideA+sideB<sideC || sideA+sideC<sideB || sideB+sideC<sideA){
            String errorTwo = "The sum of 2 sides is less than the other side";
            throw new ILLegalTriangleException(errorTwo);
        }
    }
}
