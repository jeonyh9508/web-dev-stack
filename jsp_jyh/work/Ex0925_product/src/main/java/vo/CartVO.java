package vo;

public class CartVO {

    private int idx, c_idx, p_price, p_saleprice;
    private int amount, m_idx, c_cnt;
    private String p_num, p_name, p_image_s;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getC_idx() {
        return c_idx;
    }

    public void setC_idx(int c_idx) {
        this.c_idx = c_idx;
    }

    public int getP_price() {
        return p_price;
    }

    public void setP_price(int p_price) {
        this.p_price = p_price;
    }

    public int getP_saleprice() {
        return p_saleprice;
    }

    public void setP_saleprice(int p_saleprice) {
        this.p_saleprice = p_saleprice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getM_idx() {
        return m_idx;
    }

    public void setM_idx(int m_idx) {
        this.m_idx = m_idx;
    }

    public int getC_cnt() {
        return c_cnt;
    }

    public void setC_cnt(int c_cnt) {
        this.c_cnt = c_cnt;
    }

    public String getP_num() {
        return p_num;
    }

    public void setP_num(String p_num) {
        this.p_num = p_num;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_image_s() {
        return p_image_s;
    }

    public void setP_image_s(String p_image_s) {
        this.p_image_s = p_image_s;
    }
}
