/*
 * Author: Evan Nagy
 * Date:11/17/24
 * */
#include <iostream>
#include <list>
#include <cstdlib>
#include <limits>
#include <cctype>
#include <string>
#include "Inventory.h"

using namespace std;
// displays a menu with a list of options to choose from. includes input verification
int displayMenu(){
	string option;

	cout << "Welcome to the CornerGrocer!\n"
				<< "Please type the numeric option for the action you wish to be performed.\n"
				<< "1) search for item.\n"
				<< "2) print frequently purchased products.\n"
				<< "3) print Histogram.\n"
				<< "4) exit program." << endl;
	while(true){
		cin >> option;

		if(std::isdigit(option[0]) && stoi(option) > 0 && stoi(option) <= 5){
			return stoi(option);
		}else{
			cout << "Invalid choice. Please enter a number between 1 and 4." << endl;
		}
	}
	return -1;
}

int main()
{
	Inventory* inv = new Inventory();
	string item;
	int menuOption;
	//note, data can be a property of my inventory object or even a property of a database object.
	list<list<string>> data;
	// reads the data and returns a list of lists.
	data = inv->readData();
	//displays the menu options and select which case based on the menu options.
	switch(displayMenu()){
		case 1:
			cout << "Hello, what item are you looking for?: " << endl;
			cin >> item;
			// searches for a requested word and prints it and the frequency of it.
			inv->searchInventory(data,item);
			break;

		case 2:
			//releases the entire inventory with frequency of terms
			inv->frequentlyBoughtItems(data);
			break;

		case 3:
			//releases the entire inventory with histogram of terms
			inv->printHistogram(data);
			break;

		case 4:

			break;

		case 5:
			//backs up data in a new file with the frequency of terms
			inv->backupFrequencyData("NoSqlData/frequency.dat");
			break;
	}




	return 0;
}
