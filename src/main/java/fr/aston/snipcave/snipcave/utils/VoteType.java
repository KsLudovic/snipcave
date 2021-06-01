package fr.aston.snipcave.snipcave.utils;

public enum VoteType {
    LIKE(1), DISLIKE(-1);
    private Integer value;

    VoteType(int value ){
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }
}
