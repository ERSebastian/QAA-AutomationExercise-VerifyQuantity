In this test case I verified that the selected quantity of an item is correctly displayed in the cart.

For this I used several asserts to check that we are in the correct page. Once the item is selected the test clicks on it to go to that item's page. Then I used send.keys to add a "4" on the quantity cell. Once this is done the test navigates to the cart and checks with an assert if the quantity is correct.
