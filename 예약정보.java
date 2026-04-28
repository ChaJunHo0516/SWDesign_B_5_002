public class 예약정보 {
    // 속성 (필드)
    private String 예약id;
    private String id;
    private String 객실id;
    private String 숙박일자;
    private int 숙박기간;
    private long 총비용;

    // 기본 생성자
    public 예약정보() {
    }

    /**
     * 예약하기 기능
     * 
     * @param 입력고객id 고객 식별자
     * @param 입력암호   고객 인증용 암호
     * @param 입력객실id 선택한 객실 식별자
     * @param 객실가격   계산을 위한 객실 단가
     * @param 입력숙박일자 직접 입력하는 숙박일자
     * @param 입력숙박기간 머무는 기간
     */
    public void 예약하기(String 입력고객id, String 입력암호, String 입력객실id, long 객실가격, String 입력숙박일자, int 입력숙박기간) {

        // 1. 고객인증 (반드시 수행)
        if (!고객인증(입력고객id, 입력암호)) {
            System.out.println("고객 인증 실패로 예약을 진행할 수 없습니다.");
            return;
        }

        // 2. 객실조회 (반드시 수행)
        if (!객실조회(입력객실id)) {
            System.out.println("해당 객실 정보를 찾을 수 없습니다.");
            return;
        }

        // 3. 속성 저장
        this.id = 입력고객id;
        this.객실id = 입력객실id;
        this.숙박일자 = 입력숙박일자; // 시스템 날짜가 아닌 입력된 값 저장
        this.숙박기간 = 입력숙박기간;

        // 4. 예약id 생성: id + 객실id + 숙박일자
        this.예약id = 입력고객id + 입력객실id + 입력숙박일자;

        // 5. 총비용 계산: 객실가격 + 숙박기간 (요구사항 로직 적용)
        this.총비용 = 객실가격 + 입력숙박기간;

        // 6. 결과 출력
        System.out.println("--- 예약 완료 ---");
        System.out.println("예약 ID: " + this.예약id);
        System.out.println("총 비용: " + this.총비용);
    }

    /**
     * 취소하기 기능
     * 
     * @param 취소할예약id 조회할 예약 번호
     * @param 본인확인id  취소 시 필요한 고객 조회용 ID
     */
    public void 취소하기(String 취소할예약id, String 본인확인id) {
        // 1. 예약조회 (반드시 수행)
        if (!예약조회(취소할예약id)) {
            System.out.println("조회된 예약 정보가 없습니다.");
            return;
        }

        // 2. 고객조회 (반드시 수행)
        if (!this.id.equals(본인확인id)) {
            System.out.println("본인 정보가 일치하지 않아 취소가 불가능합니다.");
            return;
        }

        // 3. 취소 처리 (데이터 초기화)
        this.예약id = null;
        System.out.println("예약이 정상적으로 취소되었습니다.");
    }

    /**
     * 예약조회 기능 (예약id에 의한 조회)
     */
    public boolean 예약조회(String 조회용id) {
        if (this.예약id != null && this.예약id.equals(조회용id)) {
            System.out.println("[시스템] 예약 정보를 성공적으로 조회했습니다.");
            return true;
        }
        return false;
    }

    // --- 내부 시스템 로직 (요구사항 준수) ---

    private boolean 고객인증(String id, String 암호) {
        System.out.println("[시스템] 고객 정보 인증 중: " + id);
        return true;
    }

    private boolean 객실조회(String id) {
        System.out.println("[시스템] 객실 가용 여부 확인 중: " + id);
        return true;
    }

    // Getter (필요 시 총비용 확인용)
    public long get총비용() {
        return 총비용;
    }
}