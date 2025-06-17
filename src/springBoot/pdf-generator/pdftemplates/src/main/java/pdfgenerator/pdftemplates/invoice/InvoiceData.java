package pdfgenerator.pdftemplates.invoice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Invoice data.
 */
public class InvoiceData {
    private String invoiceNo;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private String client;
    private String sender;
    private String clientAddress;
    private String senderAddress;
    private String clientEmail;
    private String senderEmail;
    private String clientTaxCode;
    private String senderTaxCode;
    private String currency;
    private List<LineItemData> lineItems;
    private String footer1;
    private String footer2;
    private String bankDetails;

    /**
     * Gets invoice no.
     *
     * @return the invoice no
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * Sets invoice no.
     *
     * @param invoiceNo the invoice no
     */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    /**
     * Gets invoice date.
     *
     * @return the invoice date
     */
    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * Sets invoice date.
     *
     * @param invoiceDate the invoice date
     */
    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    /**
     * Gets due date.
     *
     * @return the due date
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Sets due date.
     *
     * @param dueDate the due date
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Gets client.
     *
     * @return the client
     */
    public String getClient() {
        return client;
    }

    /**
     * Sets client.
     *
     * @param client the client
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * Gets sender.
     *
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * Sets sender.
     *
     * @param sender the sender
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * Gets client address.
     *
     * @return the client address
     */
    public String getClientAddress() {
        return clientAddress;
    }

    /**
     * Sets client address.
     *
     * @param clientAddress the client address
     */
    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    /**
     * Gets sender address.
     *
     * @return the sender address
     */
    public String getSenderAddress() {
        return senderAddress;
    }

    /**
     * Sets sender address.
     *
     * @param senderAddress the sender address
     */
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    /**
     * Gets client email.
     *
     * @return the client email
     */
    public String getClientEmail() {
        return clientEmail;
    }

    /**
     * Sets client email.
     *
     * @param clientEmail the client email
     */
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    /**
     * Gets sender email.
     *
     * @return the sender email
     */
    public String getSenderEmail() {
        return senderEmail;
    }

    /**
     * Sets sender email.
     *
     * @param senderEmail the sender email
     */
    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    /**
     * Gets client tax code.
     *
     * @return the client tax code
     */
    public String getClientTaxCode() {
        return clientTaxCode;
    }

    /**
     * Sets client tax code.
     *
     * @param clientTaxCode the client tax code
     */
    public void setClientTaxCode(String clientTaxCode) {
        this.clientTaxCode = clientTaxCode;
    }

    /**
     * Gets sender tax code.
     *
     * @return the sender tax code
     */
    public String getSenderTaxCode() {
        return senderTaxCode;
    }

    /**
     * Sets sender tax code.
     *
     * @param senderTaxCode the sender tax code
     */
    public void setSenderTaxCode(String senderTaxCode) {
        this.senderTaxCode = senderTaxCode;
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets currency.
     *
     * @param currency the currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets line items.
     *
     * @return the line items
     */
    public List<LineItemData> getLineItems() {
        return lineItems;
    }

    /**
     * Sets line items.
     *
     * @param lineItems the line items
     */
    public void setLineItems(List<LineItemData> lineItems) {
        this.lineItems = lineItems;
    }

    /**
     * Gets footer 1.
     *
     * @return the footer 1
     */
    public String getFooter1() {
        return footer1;
    }

    /**
     * Sets footer 1.
     *
     * @param footer1 the footer 1
     */
    public void setFooter1(String footer1) {
        this.footer1 = footer1;
    }

    /**
     * Gets footer 2.
     *
     * @return the footer 2
     */
    public String getFooter2() {
        return footer2;
    }

    /**
     * Sets footer 2.
     *
     * @param footer2 the footer 2
     */
    public void setFooter2(String footer2) {
        this.footer2 = footer2;
    }

    /**
     * Gets bank details.
     *
     * @return the bank details
     */
    public String getBankDetails() {
        return bankDetails;
    }

    /**
     * Sets bank details.
     *
     * @param bankDetails the bank details
     */
    public void setBankDetails(String bankDetails) {
        this.bankDetails = bankDetails;
    }

    /**
     * Gets subtotal.
     *
     * @return the subtotal
     */
    public double getSubtotal() {
        return lineItems.stream().mapToDouble(LineItemData::getItemTotal).sum();
    }

    /**
     * Gets tax subtotals.
     *
     * @return the tax subtotals
     */
    public Map<String, Double> getTaxSubtotals() {
        Map<String, Double> totals = new HashMap<>(lineItems.size());
        for (LineItemData item : lineItems) {
            totals.put(item.getTaxName(), totals.getOrDefault(item.getTaxName(), 0.0) + item.getTaxTotal());
        }
        return totals;
    }

    /**
     * Gets total.
     *
     * @return the total
     */
    public double getTotal() {
        return getSubtotal() + lineItems.stream().mapToDouble(LineItemData::getTaxTotal).sum();
    }
}