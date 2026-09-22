package com.sneha.splitwiseTwo;

import java.util.ArrayList;
import java.util.List;

public class ExpenseSplitCalculator {

    List<ExpenseSplitRecord> calculate(GroupInfo groupInfo) {
        List<ExpenseSplitRecord> records = new ArrayList<>();

        List<FriendExpenseRatio> senderList = groupInfo.getSender();

        List<FriendExpenseRatio> receiverList = groupInfo.getReceiver();

        while (senderList.size() != 0 && receiverList.size() != 0) {

            FriendExpenseRatio senderFriend = senderList.getFirst();
            System.out.println("Sender friend" + senderFriend.getAmount().getValue());

            FriendExpenseRatio receiverFriend = receiverList.getFirst();
            System.out.println("receiver friend " + receiverFriend.getAmount().getValue());

            if (senderFriend.getAmount().getValue() > receiverFriend.getAmount().getValue()) {
                System.out.println("Sender paying");

                records.add(new ExpenseSplitRecord(senderFriend.getFriend(), receiverFriend.getFriend(), new Amount(receiverFriend.getAmount().getValue())));
                int diff = senderFriend.getAmount().getValue() - receiverFriend.getAmount().getValue();

                receiverList.remove(receiverFriend);

                FriendExpenseRatio updateSender = senderList.removeFirst();
                senderList.addFirst(new FriendExpenseRatio(updateSender.getFriend(), new Amount(diff)));

            } else if (senderFriend.getAmount().getValue() < receiverFriend.getAmount().getValue()) {
                System.out.println("Second block");

                records.add(new ExpenseSplitRecord(senderFriend.getFriend(), receiverFriend.getFriend(), new Amount(senderFriend.getAmount().getValue())));
                int diff = receiverFriend.getAmount().getValue() - senderFriend.getAmount().getValue();

                senderList.remove(senderFriend);

                FriendExpenseRatio updateReceiver = receiverList.removeFirst();
                receiverList.addFirst(new FriendExpenseRatio(updateReceiver.getFriend(), new Amount(diff)));
            } else {
                System.out.println("Third block");

                records.add(new ExpenseSplitRecord(senderFriend.getFriend(), receiverFriend.getFriend(), new Amount(senderFriend.getAmount().getValue())));
                senderList.remove(senderFriend);
                receiverList.remove(receiverFriend);

            }
        }

        return records;
    }
}
