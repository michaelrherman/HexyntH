package gui;

/**
 * listens for & fires off toolbar events
 */
public interface ToolBarListener {
    void saveClicked();
    void loadClicked();
    void clearClicked();
    void startClicked();
    void pauseClicked();
    void stopClicked();
    void recordClicked();
}
