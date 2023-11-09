package com.seungh1024.generic;

public class GenericSample {
    public static void main(String[] args) {
        GenericSample sample = new GenericSample();
        sample.checkCastingDTO();
        sample.checkGenericDTO();
    }

    private void checkCastingDTO() {
        CastingDTO dto1 = new CastingDTO();
        dto1.setObject(new String());

        CastingDTO dto2 = new CastingDTO();
        dto2.setObject(new StringBuffer());

        CastingDTO dto3 = new CastingDTO();
        dto3.setObject(new StringBuilder());

        String s1 = (String) dto1.getObject();
        StringBuffer s2 = (StringBuffer) dto2.getObject();
    }

    private void checkGenericDTO() {
//        CastingGenericDTO<String> dto1 = new CastingGenericDTO<String>();
//        dto1.setObject(new String());
//
//        CastingGenericDTO<StringBuffer> dto2 = new CastingGenericDTO<StringBuffer>();
//        dto2.setObject(new StringBuffer());
//
//        CastingGenericDTO<StringBuilder> dto3 = new CastingGenericDTO<StringBuilder>();
//        dto3.setObject(new StringBuilder());
//
//        String s1 = dto1.getObject();
//        StringBuffer s2 = dto2.getObject();
//        StringBuilder s3 = dto3.getObject();
    }
}
