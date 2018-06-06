package numplate.com.abelov.customnumplateview;

public enum NumberPlate {
    RU(R.layout.layout_numplate_ru, R.drawable.auto_number, "[АВЕКМНОСТУХ]", R.id.tvNum, R.id.tvRegion, R.id.tvMotoSuffix),
    RU_MOTO(R.layout.layout_numplate_ru_constrain, R.drawable.numplate_moto_normal, "[ABCD]", R.id.tvNum, R.id.tvRegion, R.id.tvMotoSuffix),

    UA(R.layout.layout_numplate_ru, R.drawable.auto_number, "[АВЕIКМНОРСТХ]", R.id.tvNum, R.id.tvRegion, R.id.tvMotoSuffix);

    int resourceId;
    int backgroundId;

    int etNumberId;

    int etRegionId;
    int etNumberMotoSuffixId;

    String regexPattern;


    NumberPlate(int resourceId, int backgroundId, String regexPattern, int numberEtId, int regionEtId, int etNumberMotoSuffixId) {
        this.resourceId = resourceId;
        this.backgroundId = backgroundId;
        this.regexPattern = regexPattern;
        this.etNumberId = numberEtId;
        this.etRegionId = regionEtId;
        this.etNumberMotoSuffixId = etNumberMotoSuffixId;
    }

}
