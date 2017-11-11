#include <iostream>
#include <string>
#include <vector>

/*
	[2017-11-08] Challenge #336 [Intermediate] A car renting problem.

	Solves by check for requests that cause the highest amount of collisions with other
	rent requests and removing them util none exsit.

	requests, are amount of requests for a certain car in one timespan.
	start_d, end_d, first and last of renting that car.

*/


bool all_equal_zero(std::vector<int> &c);
int largest_collision_index(std::vector<int> &c);
void set_vec_to_zero(std::vector<int> &c);

int main(int argc, char** argv)
{
	int requests = 10;
	std::vector<int> start_d = {1, 5, 10, 12, 13, 19,  22, 30, 40, 70};
	std::vector<int> end_d = {23, 10, 12, 29, 25, 65, 33, 35, 66, 10};
	std::vector<int> collisions = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	bool collision_exsists = true;
	while(collision_exsists)
	{
		for(int i=0; i < requests; i++)
		{
			int i_t = i+1;
			while(i_t < requests && end_d[i] >= start_d[i_t])
			{
				collisions[i] += 1;
				collisions[i_t++] += 1;
			}
		}
		collision_exsists = all_equal_zero(collisions);
		if(collision_exsists)
		{
			int remove_index = largest_collision_index(collisions);
			start_d.erase(start_d.begin() + remove_index);
			end_d.erase(end_d.begin() + remove_index);
			set_vec_to_zero(collisions);
			requests--;
		}
	}
	std::cout << start_d.size() << std::endl;
	return 0;
}

bool all_equal_zero(std::vector<int> &c)
{
	for(int i=0; i < c.size(); i++)
	{
		if(c[i] > 0)
			return true;
	}
	return false;
}
void set_vec_to_zero(std::vector<int> &c)
{
	for(int i=0; i < c.size(); i++)
	{
		c[i] = 0;

	}
}
int largest_collision_index(std::vector<int> &c)
{
	int i_b = 0;
	for(int i=0; i < c.size(); i++)
	{
		if(c[i] > c[i_b])
		{
			i_b = i;
		}
	}	
	return i_b;
}
