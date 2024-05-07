package designPatterns.labs.lab05_alternate.commands;

import designPatterns.labs.lab05_alternate.Account;

public class DepositCommand implements Command {

        private final Account acc;
        private final double amount;
        private final String description;


        public DepositCommand(Account acc, double amount, String description){
            this.acc = acc;
            this.amount = amount;
            this.description = description;
        }

        public void execute() {
            this.acc.deposit(this.amount,this.description);
        }

        @Override
        public void redo() {
            this.acc.deposit(this.amount,"redo:"+this.description);
        }

        @Override
        public void undo() {
            this.acc.withdraw(this.amount,"undo:"+this.description);
        }
}
