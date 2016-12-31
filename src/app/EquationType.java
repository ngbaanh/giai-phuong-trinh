/**
 * 
 */
package app;

/**
 * @author ngbaanh
 * Danh sách các loại phương trình 
 */
public enum EquationType {
	LINEAR_EQUATION("Phương trình bậc nhất"), 
	POLYNOMIAL_EQUATION("Phương trình bậc hai");

    private final String text;

    private EquationType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
