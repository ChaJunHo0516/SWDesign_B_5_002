package room;

public class 예약정보 {
    private String 예약id;
    private String id;
    private String 객실id;
    private int 숙박일자;
    private int 숙박기간;
    private double 총비용;

    private 고객정보 _user;
    private 객실정보 _room;

    public 예약정보() {
        _user = new 고객정보();
        _room = new 객실정보();
    }

    public double 예약(String id, String 객실id, int 숙박일자, int 숙박기간) {
        if (_user.고객인증(id)) {
            if (_room.객실조회(객실id)) {
                this.예약id = id + 객실id;
                this.id = id;
                this.객실id = 객실id;
                this.숙박일자 = 숙박일자;
                this.숙박기간 = 숙박기간;
                this.총비용 = 숙박기간 * _room.객실가격조회(객실id);

                return this.총비용;
            } else {
                return -2;
            }
        } else {
            return -1;
        }
    }
}
