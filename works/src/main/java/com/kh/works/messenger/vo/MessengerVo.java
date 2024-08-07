package com.kh.works.messenger.vo;

import lombok.Data;

@Data
public class MessengerVo {

    //이거 수정함 주의!!!!
    private String messenNo;
    private String senderEmpNo;
    private String receiverEmpNo;
    private String messenboxTypeNo;
    private String title;
    private String content;
    private String sendDate;
    private String readYn;
    private String isSave;
    private String updateDate;
    private String delYn;

    //EMPLOYEE 테이블에서 name을 가지고 오기 위해 생성
    private String name;

    //쪽지 상세페이지에서 수신자, 발신자 이름을 가지고 오기 위해 생성
    private String senderName;
    private String receiverName;

    //쪽지 중요 여부를 나타내기 위해 생성
    private String isImportant;

    //검색 기능을 추가하기 위해 생성
    private String keyWord;

}