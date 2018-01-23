package read.it.ratioimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * @des:
 * @author: flx
 * @version: 1
 * @date: 2018/1/23 14:55
 * @see {@link }
 */
public class RatioImageView extends AppCompatImageView{
    private float ratio;

    public RatioImageView(Context context) {
        this(context,null);
    }

    public RatioImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView);
        ratio = typedArray.getFloat(R.styleable.RatioImageView_ratio, 1.0f);
    }

    public RatioImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取宽度的模式和尺寸
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        //获取高度的模式和尺寸
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        //宽确定，高不确定
        if(widthMode == MeasureSpec.EXACTLY&&heightMode!=MeasureSpec.EXACTLY&&ratio!=0){
            heightSize = (int) (widthSize*ratio+0.5f);//根据宽度和比例计算高度
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize, MeasureSpec.EXACTLY);
        }else if(widthMode!=MeasureSpec.EXACTLY&&heightMode==MeasureSpec.EXACTLY&&ratio!=0){
            widthSize = (int) (heightSize/ratio+0.5f);
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(widthSize,MeasureSpec.EXACTLY);
        }else{
            heightSize = (int) (widthSize*ratio+0.5f);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize, MeasureSpec.EXACTLY);
        }
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }
    /**
     * 设置宽高比
     * @param ratio
     */
    public void setRatio(float ratio){
        this.ratio = ratio;
    }
}
