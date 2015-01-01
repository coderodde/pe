/**
 * Solves the problem 19: Counting Sundays.
 */
public class Problem0019 extends AbstractProblem {

    private static class MyDate {
        private int day;
        private int month;
        private int year;
        private int weekDay;
        
        MyDate(final int day, final int month, final int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
        
        public boolean equals(final Object o) {
            if (!(o instanceof MyDate)) {
                return false;
            }
            
            MyDate d = (MyDate) o;
            return this.day == d.day && this.month == d.month && this.year == d.year;
        }
        
        void setWeekDay(final int weekDay) {
            this.weekDay = weekDay;
        }
        
        int getWeekDay() {
            return this.weekDay;
        }
        
        int getDay() {
            return this.day;
        }
        
        void nextDay() {
            int maximumDay = 0;
            
            switch (month) {
                // January.
                case 0:
                    maximumDay = 31;
                    break;
                    
                // February.
                case 1:
                    if (year % 4 != 0) {
                        maximumDay = 28;
                    } else {
                        // Possible leap year.
                        if (year % 100 == 0) {
                            if (year % 400 == 0) {
                                maximumDay = 29;
                            } else {
                                maximumDay = 28;
                            }
                        } else {
                            maximumDay = 29;
                        }
                    }
                
                    break;
                    
                // March.
                case 2:
                    maximumDay = 31;
                    break;
                    
                // April.
                case 3:
                    maximumDay = 30;
                    break;
                    
                // May.
                case 4:
                    maximumDay = 31;
                    break;
                    
                // June.
                case 5:
                    maximumDay = 30;
                    break;
                    
                // July.
                case 6:
                    maximumDay = 31;
                    break;
                    
                // August.
                case 7:
                    maximumDay = 31;
                    break;
                    
                // September.
                case 8:
                    maximumDay = 30;
                    break;
                
                // October.
                case 9:
                    maximumDay = 31;
                    break;
                    
                // November.
                case 10:
                    maximumDay = 30;
                    break;
                    
                // December.
                case 11:
                    maximumDay = 31;
                    break;
                    
                default:
                    throw new IllegalStateException();
            }
            
            if (day == maximumDay) {
                day = 1;
                ++month;
                
                if (month == 12) {
                    month = 0;
                    ++year;
                }
            } else {
                ++day;
            }
            
            ++weekDay;
            
            if (weekDay == 7) {
                weekDay = 0;
            }
        }
    }
    
    @Override
    public void solve() {
        MyDate date = new MyDate(1, 0, 1900);
        MyDate start = new MyDate(1, 0, 1901);
        MyDate end = new MyDate(31, 11, 2000);
        // 0 is Monday. 6 is Sunday.
        date.setWeekDay(0);
        
        while (!date.equals(start)) {
            date.nextDay();
        }
        
        start.setWeekDay(date.getWeekDay());
        
        int count = 0;
        
        do {
            if (date.getDay() == 1 && date.getWeekDay() == 6) {
                ++count;
            }
            date.nextDay();
        } while (!date.equals(end));
        
        System.out.println(count);
    }
}
