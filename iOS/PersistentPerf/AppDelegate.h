//
//  AppDelegate.h
//  PersistentPerf
//
//  Created by Mike Fikes on 11/12/14.
//
//

#import <UIKit/UIKit.h>

@class GBYManager;

@interface AppDelegate : UIResponder <UIApplicationDelegate>

@property (strong, nonatomic) UIWindow *window;
@property (strong, nonatomic) GBYManager* cljsManager;

@end

