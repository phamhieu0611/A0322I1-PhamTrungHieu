package exception_debug.bai_tap;

public class SideTriangle {
    public SideTriangle(int sideA, int sideB, int sideC) throws ILLegalTriangleException{
        if (sideA < 0|| sideB < 0|| sideC < 0){
            throw new ILLegalTriangleException("The side can not less than 0!");
        }
    }
}
