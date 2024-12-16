/*
 * Inventory.cpp
 *
 *  Created on: Nov 17, 2024
 *      Author: evannagy_snhu
 */
#include <list>
#include <cstdlib>
#include <string>
#include <iostream>
#include <fstream>
#include <iomanip>
#include "Inventory.h"
#include <map>

using namespace std;

Inventory::Inventory() {
	// TODO Auto-generated constructor stub

}

Inventory::~Inventory() {
	// TODO Auto-generated destructor stub
}
//reads the data from a txt file and returns a list of lists.
//also creates a map "a dictionary" of the frequency of words within the data we are using.
list<list<string>> Inventory::readData(){
	ifstream inStream;
	string produce, purchaseHistory;
	list<string> lProduce;
	list<list<string>> data;
	int count = 0;
	// opens the file that we are using as our database
	inStream.open(this->DataFile);

	// Check file open success
	if (!inStream.is_open()) {
		cerr << "Error opening file: " << this->DataFile << endl;
	        return data;
	    }
	// keep runing until we reach the end of file
	while(!inStream.eof()){
		// get the data and push it back to the end of the list
		inStream >> produce;
		lProduce.push_back(produce);
		// this is our map where we are storing our frequency data
		this->freqData[produce]++;
	}
	// close our file
	inStream.close();
	//push it back into our list
	data.push_back(lProduce);

	return data;
}

// Writes the frequency data to a backup file
    void Inventory::backupFrequencyData(string filename) {
        ofstream output(filename);
        if (output.fail()) {
            cout << "Error: Could not open file " << filename << endl;
            return;
        }
        for (auto it = freqData.begin(); it != freqData.end(); ++it) {
            output << it->first << ": " << it->second << endl;
        }
        output.close();
    }

// print a histogram of our produce
void Inventory::printHistogram(list<list<string>> data){
	int count = 0;

		//get unique terms
			for(auto& i : data){
				list<string> uniqueTerms(i);
				uniqueTerms.sort();
				uniqueTerms.unique();
				//compare our unique terms with the terms in the file
				for(auto& term : uniqueTerms){
					// when a term matches a unique term, then count it.
					for(auto& item : i){

						if(term == item){
							count++;

					}

					}
					//print the information with histogram
				cout << setw(12) << term << " ";
				for(int i=0;i<=count;i++){
					cout << "*";
				}
					cout << endl;
					count = 0;
				}
			}
			}


void Inventory::frequentlyBoughtItems(list<list<string>> data){
	int count = 0;

	//get unique terms
		for(auto& i : data){
			list<string> uniqueTerms(i);
			uniqueTerms.sort();
			uniqueTerms.unique();
			//compare our unique terms with the terms in the file
			for(auto& term : uniqueTerms){
				// when a term matches a unique term, then count it.
				for(auto& item : i){

					if(term == item){
						count++;

				}

				}
				//print the information
				cout << term << " " << count << endl;
				count = 0;
			}
		}


}
// searches inventory for specified word and releases how many items contains that word.
//warning capital case sensitive
void Inventory::searchInventory(list<list<string>> data, string term){
	int count = 0;
	for(auto& i : data){


			for(auto& c : i){
				if(c.find(term) != -1){
					count++;
			}
		}
	}

	cout << "there are " << count << " entries that contain the word " << term << endl;

}
