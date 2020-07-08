package com.skcc.nxm.core.domain.entity.etc;

public enum GrpCommonCode {
    // Common
    // 정의가 필요 함.
    ORGANCODE_R1("ORGANRESEARCH", "R1"), // 개인정보 조회 요청구분
    ORGANCODE_R2("ORGANRESEARCH", "R2"), // 정보제공활용동의 조회 요청구분
    ORGANCODE_R9("ORGANRESEARCH", "R9"), // ci+개인정보 조회 요청구분
    ORGANCODE_M4("ORGANRESEARCH", "M4"); // 카드등록 요청구분

    private final String groupCode;
    private final String commonCode;
    private int status;

    GrpCommonCode(final String groupCode, final String commonCode) {
        this.groupCode = groupCode;
        this.commonCode = commonCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public String getCommonCode() {
        return commonCode;
    }

}
