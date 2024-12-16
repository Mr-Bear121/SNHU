/*
 * Inventory.h
 *
 *  Created on: Nov 17, 2024
 *      Author: evannagy_snhu
 */

#ifndef SRC_INVENTORY_H_
#define SRC_INVENTORY_H_
#include <list>
#include <string>
#include <map>
using namespace std;

class Inventory {
public:
	Inventory();
	virtual ~Inventory();

	void searchInventory(list<list<string>> data, string term);
	void frequentlyBoughtItems(list<list<string>> data);
	void printHistogram(list<list<string>> data);
	void backupFrequencyData(string filename);

	std::list<list<string>> readData();

private:
	string DataFile = "NoSqlData/produce.txt";
	map<string, int> freqData;


};

#endif /* SRC_INVENTORY_H_ */
