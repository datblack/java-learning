package datmt.learning.funtional_interface;
public class PlusImpl {
    int tienNoThangTruoc;
    int tienNo;

    public PlusImpl(int tienNoThangTruoc, int tienNo) {
        this.tienNoThangTruoc = tienNoThangTruoc;
        this.tienNo = tienNo;
    }

    public int getTienNoThangTruoc() {
        return tienNoThangTruoc;
    }

    public void setTienNoThangTruoc(int tienNoThangTruoc) {
        this.tienNoThangTruoc = tienNoThangTruoc;
    }

    public int getTienNo() {
        return tienNo;
    }

    public void setTienNo(int tienNo) {
        this.tienNo = tienNo;
    }

    public int tongNo(PlusFI plusFI){
        return plusFI.plus(tienNo, tienNoThangTruoc);
    }
}
