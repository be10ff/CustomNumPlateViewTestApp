package numplate.com.abelov.customnumplateview;

public enum NumberPlate {
    RU(R.layout.layout_numplate_ru, R.drawable.auto_number, R.id.tvNum, R.id.tvRegion, R.id.tvMotoSuffix),
    RU_MOTO(R.layout.layout_numplate_moto_ru, R.drawable.numplate_moto_normal, R.id.tvNum, R.id.tvRegion, R.id.tvMotoSuffix),
    UA(R.layout.layout_numplate_ru, R.drawable.auto_number, R.id.tvNum, R.id.tvRegion, R.id.tvMotoSuffix);

    int resourceId;
    int backgroundId;

    int etNumberId;

    int etRegionId;
    int etNumberMotoSuffixId;


    NumberPlate(int resourceId, int backgroundId, int numberEtId, int regionEtId, int etNumberMotoSuffixId) {
        this.resourceId = resourceId;
        this.backgroundId = backgroundId;
        this.etNumberId = numberEtId;
        this.etRegionId = regionEtId;
        this.etNumberMotoSuffixId = etNumberMotoSuffixId;
    }

}
