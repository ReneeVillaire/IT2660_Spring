public class StackItUp {
        private StudentListing[] data;
        private int top;
        private int size;

        public StackItUp() {
            top = -1; 
            size = 3;
            data = new StudentListing[size]; 
        }

        public StackItUp(int n) {
            top = -1;
            size = n;
            data = new StudentListing[size];
        }

        public boolean isEmpty() {
            if(top <= -1)
                return true;
            else
                return false;
        }

        public boolean isFull() {
            if(top == (size - 1))
                return true;
            else
                return false;
        }

        public void clear() {
            top = -1;
            data = new StudentListing[size];
        }

        public void push(StudentListing newNode) {
            if (top == (size -1)) {
                StudentListing[] temp = new StudentListing[size];

                for(int idx = 0; idx < size; idx++) {
                        var currentTop = pop();

                        if(currentTop != null)
                            temp[idx] = currentTop;
                }

                size *=2;

                data = new StudentListing[size];
                top = 0;

                for(int idx = temp.length-1; idx >= 0; idx --) {
                    data[top] = temp[idx];
                    top++;
                }

                data[top] = newNode.deepCopy();
            }

            else{
                top++;
                data[top] = newNode.deepCopy();
            }
        }

        public StudentListing peek() {
            if(top <= -1)
                return null;
            else
                return data[top];
        }

        public StudentListing pop() {
            int oldTop;
            
            if(top == -1)
                return null;
            else{
                oldTop = top;
                top--;
                return data[oldTop];
            }
        }
        
        public void showAll() {
            for(int i = top; i >=0; i--) {
                System.out.println(data[i].toString());
            }
        }
    }
