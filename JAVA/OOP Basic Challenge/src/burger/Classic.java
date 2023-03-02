package burger;

public class Classic extends Burger {
        private String type;
        private double baconAmount;
        private String cheesType;
        private int pickledAmount;
        private int cheeseAmount;
        private double classicPrice;

        public Classic() {
                super();
                this.type = "Classic";
                this.baconAmount = 1;
                this.cheesType = "cheddar";
                this.cheeseAmount = 1;
                this.pickledAmount = 4;
                this.classicPrice = 12.4;
                setBurgerPrice(classicPrice);
        }

        @Override
        public String toString() {
                return """
                        Classic Burger
                        --------------
                            1x beef meat
                            1x cheddar
                            1x bacon
                            4x pickles                    
                        """ + "\tprice " + classicPrice + "€";
        }

        @Override
        public void additionalBacon(double amount) {
                if (amount < 0) this.baconAmount = 1;
                baconAmount = (baconAmount + amount);
                classicPrice = classicPrice + (amount * super.baconPrice);
                setBurgerPrice(classicPrice);
        }

        @Override
        public void additionalCheese(int cheese) {
                if (cheese < 0) cheeseAmount = 1;
                cheeseAmount = (cheeseAmount + cheese);
                classicPrice = classicPrice + (cheese * cheesePrice);
        }

        public double getClassicPrice() {
                return classicPrice;
        }
}
