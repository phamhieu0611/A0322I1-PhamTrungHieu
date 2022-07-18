package exception_debug.bai_tap;

public class SideTriangleTwo {
    public SideTriangleTwo(int sideA, int sideB, int sideC) throws ILLegalTriangleException{
        if (sideA+sideB<sideC || sideA+sideC<sideB || sideB+sideC<sideA){
            throw new ILLegalTriangleException("The sum of 2 sides is less than the other side");
        }
    }
}
