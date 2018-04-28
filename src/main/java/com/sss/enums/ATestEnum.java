package com.sss.enums;

public class ATestEnum {

   public enum Enum2{
       a,b,c;
    }

    public enum Enum1{
        YES("1"),NO("0");
        private String value;
        private Enum1(String value){
            this.value = value;
        }

        public String getValue(){
            return value;
        }

    }

}
