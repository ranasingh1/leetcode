class BrowserHistory {
    private List<String> history;
    private int currentIndex;
    
    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        currentIndex = 0;
    }
    
    public void visit(String url) {
        history = history.subList(0, currentIndex + 1);
        history.add(url);
        currentIndex++;
    }
    
    public String back(int steps) {
        currentIndex = Math.max(0, currentIndex - steps);
        return history.get(currentIndex);
    }
    
    public String forward(int steps) {
        currentIndex = Math.min(history.size() - 1, currentIndex + steps);
        return history.get(currentIndex);
    }
}