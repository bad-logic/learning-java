package pdfgenerator.pdftemplates.invoice;

/**
 * The type Line item data.
 */
public class LineItemData {
    private String description;
    private int quantity;
    private String unitFormat;
    private double unitPrice;
    private String taxName;
    private double taxRate;

    /**
     * Gets unit format.
     *
     * @return the unit format
     */
    public String getUnitFormat() {
        return unitFormat;
    }

    /**
     * Sets unit format.
     *
     * @param unitFormat the unit format
     */
    public void setUnitFormat(String unitFormat) {
        this.unitFormat = unitFormat;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets unit price.
     *
     * @return the unit price
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets unit price.
     *
     * @param unitPrice the unit price
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Gets tax name.
     *
     * @return the tax name
     */
    public String getTaxName() {
        return taxName;
    }

    /**
     * Sets tax name.
     *
     * @param taxName the tax name
     */
    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    /**
     * Gets tax rate.
     *
     * @return the tax rate
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * Sets tax rate.
     *
     * @param taxRate the tax rate
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * Gets item total.
     *
     * @return the item total
     */
    public double getItemTotal() {
        return unitPrice * quantity;
    }

    /**
     * Gets tax total.
     *
     * @return the tax total
     */
    public double getTaxTotal() {
        return unitPrice * quantity * taxRate;
    }
}
