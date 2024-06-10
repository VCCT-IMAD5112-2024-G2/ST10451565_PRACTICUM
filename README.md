Curlin Campher 
ST10451565
Pseudocode

MainScreen:
Initialize dates as ArrayList<String>
Initialize minTemps as ArrayList<Int>
Initialize maxTemps as ArrayList<Int>
Initialize weatherConditions as ArrayList<String>
Initialize avgTemp as Integer

Initialize dateEditText
Initialize minTempEditText
Initialize maxTempEditText
Initialize weatherConditionEditText

Initialize addButton
Initialize clearButton
Initialize detailedViewButton
Initialize exitButton2

On exitButton2 click:
    Finish current activity

On addButton click:
    Retrieve date from dateEditText
    Retrieve minTemp from minTempEditText
    Retrieve maxTemp from maxTempEditText
    Retrieve weatherCondition from weatherConditionEditText
    If all inputs are valid:
        Add date to dates
        Add minTemp to minTemps
        Add maxTemp to maxTemps
        Add weatherCondition to weatherConditions
        Clear input fields
        Show success message
        Update average temperature
    Else:
        Show error message

On clearButton click:
    Clear dates
    Clear minTemps
    Clear maxTemps
    Clear weatherConditions
    Clear input fields
    Show data cleared message

On detailedViewButton click:
    Create Intent to navigate to DetailedViewScreenActivity
    Pass dates, minTemps, maxTemps, weatherConditions, and avgTemp to DetailedViewScreenActivity
    Start DetailedViewScreenActivity

Function updateAverageTemperature:
    If minTemps and maxTemps are not empty:
        Set totalTemp to 0
        Set count to size of minTemps
        For each index i from 0 to count:
            Add (minTemps[i] + maxTemps[i]) / 2 to totalTemp
        Set avgTemp to totalTemp divided by count
    Else:
        Set avgTemp to 0


DetailedViewScreenActivity:
Initialize detailsTextView
Initialize avgTempTextView
Initialize backButton

Retrieve dates, minTemps, maxTemps, weatherConditions, and avgTemp from Intent

Initialize details as StringBuilder

For each index i from 0 to size of dates:
    Append date, minTemp, maxTemp, and weatherCondition to details

Set detailsTextView text to details.toString()
Set avgTempTextView text to "Average Temperature: avgTemp°C"

On backButton click:
    Finish current activity

Retrieve dates, minTemps, maxTemps, weatherConditions, and avgTemp from Intent

Initialize details as StringBuilder

For each index i from 0 to size of dates:
    Append date, minTemp, maxTemp, and weatherCondition to details

Set detailsTextView text to details.toString()
Set avgTempTextView text to "Average Temperature: avgTemp°C"

On backButton click:
    Finish current activity
